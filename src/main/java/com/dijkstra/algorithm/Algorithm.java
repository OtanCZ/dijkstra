package com.dijkstra.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Algorithm {
    private List<Node> nodes;


    public Algorithm() {
        this.nodes = new ArrayList<>();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void createNode(String name){
        nodes.add(new Node(name));
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void deleteNode(String name){
        nodes.remove(findNodeByName(name));
    }

    public void deleteNode(Node node){
        nodes.remove(node);
    }

    public Node findNodeByName(String name){
        for(Node node : nodes){
            if(node.getName().equals(name)){
                return node;
            }
        }
        return null;
    }

    public void addConnection(String nodeName, String connectedNodeName, int weight){
        Node node = findNodeByName(nodeName);
        Node connectedNode = findNodeByName(connectedNodeName);
        node.getConnectedNodeNames().put(connectedNodeName, weight);
        connectedNode.getConnectedNodeNames().put(nodeName, weight);
    }

    public void deleteConnection(String nodeName, String connectedNodeName) {
        Node node = findNodeByName(nodeName);
        Node connectedNode = findNodeByName(connectedNodeName);
        node.getConnectedNodeNames().remove(connectedNodeName);
        connectedNode.getConnectedNodeNames().remove(nodeName);
    }

    public List calculateShortestPathFromSource(Node source, Node destination){
        List visited = new ArrayList();
        List<Node> unvisited = this.getNodes();

        //idk
        return null;
    }



    @Override
    public String toString() {
        return "Algorithm{" +
                "nodes=" + nodes +
                '}';
    }
}
