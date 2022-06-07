package com.dijkstra.javafx;

import com.dijkstra.algorithm.Algorithm;
import com.dijkstra.algorithm.Node;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class Controller {
    public ToolBar infoField;
    public TextField popupNodeName;
    public AnchorPane mainAnchorPane;
    public ChoiceBox pathFrom;
    public ChoiceBox pathTo;
    public TextField nodeName;
    public TextField infoText;
    public TextField pathWeight;
    public ListView pathList;
    public ListView nodeList;
    public CheckBox pathBothWays;
    Algorithm algorithm = new Algorithm();

    public void createNodeButtonClick(ActionEvent actionEvent) {
        if(algorithm.findNodeByName(nodeName.getText()) == null) {
            algorithm.createNode(nodeName.getText());
            infoText.setText("Node " + nodeName.getText() + " created.");
            nodeList.getItems().add(algorithm.findNodeByName(nodeName.getText()));
        }
        else {
            infoText.setText("Node with name " + nodeName.getText() + " already exists.");
        }
    }

    public void createPathButtonClick(ActionEvent actionEvent) {
        if(pathFrom.getValue() == null || pathTo.getValue() == null){
            infoText.setText("Choose path from and to");
            return;
        }
        if(pathWeight.getText().matches("[a-zA-Z]+") && !pathWeight.getText().equals("")){
            infoText.setText("Enter path weight in numbers.");
            return;
        }

        if(algorithm.findNodeByName(pathFrom.getValue().toString()).getConnectedNodeNames().containsKey(pathTo.getValue().toString())){
            infoText.setText("Path already exists.");
            return;
        }

        if(pathBothWays.isSelected()){
            algorithm.findNodeByName(pathTo.getValue().toString()).addConnection(pathFrom.getValue().toString(), Integer.parseInt(pathWeight.getText()));
            pathList.getItems().add(pathTo.getValue().toString() + " -> " + pathFrom.getValue().toString() + " | " + pathWeight.getText());
        }
        algorithm.findNodeByName(pathFrom.getValue().toString()).addConnection(pathTo.getValue().toString(), Integer.parseInt(pathWeight.getText()));
        infoText.setText("Path from " + pathFrom.getValue().toString() + " to " + pathTo.getValue().toString() + " with weight " + pathWeight.getText() + " added.");
        pathList.getItems().add(pathFrom.getValue().toString() + " -> " + pathTo.getValue().toString() + " | " + pathWeight.getText());
    }

    public void tabPaneChange(Event event) {
        pathFrom.getItems().clear();
        pathTo.getItems().clear();
        for(Node node : algorithm.getNodes()){
            pathFrom.getItems().add(node.getName());
            pathTo.getItems().add(node.getName());
        }
    }
}