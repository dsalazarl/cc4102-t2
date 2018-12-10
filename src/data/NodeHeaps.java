package data;

import data.graph.Pair;

import java.util.ArrayList;

public class NodeHeaps {
    private int id;
    private double nodeKey;
    private ArrayList<NodeHeaps> childList;
    private NodeHeaps parent, left, right;
    private int childSize;
    private boolean markeD;

    public NodeHeaps(){
        childList = new ArrayList<>();
        parent = null;
        left = null;
        right = null;
        childSize = 0;
        markeD = false;
    }

    public NodeHeaps(Integer nodeId, Double key){
        this();
        this.id = nodeId;
        this.nodeKey = key;
    }

    public void addChild(NodeHeaps nodeChild){
        this.childList.add(nodeChild);
        this.childSize++;
    }

    public void removeChild(NodeHeaps eraseNode){
        this.childList.remove(eraseNode);
        this.childSize--;
    }

    public double getKey(){
        return nodeKey;
    }

    public void setKey(int key) {
        this.nodeKey = key;
    }

    public void resetChildList(NodeHeaps object){
        childList.clear();
        childList.add(object);
    }

    public Pair<Integer, Double> nodeToPair() {
        Pair<Integer, Double> newPair = new Pair<>(this.id, this.getKey());
        return newPair;
    }

    public void setNodeKey(int nodeKey) {
        this.nodeKey = nodeKey;
    }

    public ArrayList<NodeHeaps> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<NodeHeaps> childList) {
        this.childList = childList;
    }

    public NodeHeaps getParent() {
        return parent;
    }

    public void setParent(NodeHeaps parent) {
        this.parent = parent;
    }

    public NodeHeaps getLeft() {
        return left;
    }

    public void setLeft(NodeHeaps left) {
        this.left = left;
    }

    public NodeHeaps getRight() {
        return right;
    }

    public void setRight(NodeHeaps right) {
        this.right = right;
    }

    public int getChildSize() {
        return childSize;
    }

    public void setChildSize(int childSize) {
        this.childSize = childSize;
    }

    public boolean isMarkeD() {
        return markeD;
    }

    public void setMarkeD(boolean markeD) {
        this.markeD = markeD;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
