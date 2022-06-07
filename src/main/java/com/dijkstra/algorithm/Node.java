package com.dijkstra.algorithm;
import java.util.HashMap;
import java.util.Map;

public class Node {
    String name;
    Map<String, Integer> connectedNodeNames;

    public Node(String name) {
        this.name = name;
        this.connectedNodeNames = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getConnectedNodeNames() {
        return connectedNodeNames;
    }

    public void setConnectedNodeNames(Map<String, Integer> connectedNodeNames) {
        this.connectedNodeNames = connectedNodeNames;
    }

    public void addConnection(String connectedNodeName, int weight){
        connectedNodeNames.put(connectedNodeName, weight);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", connectedNodeIndexes=" + connectedNodeNames +
                '}';
    }
}
