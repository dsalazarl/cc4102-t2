package data.priority_queue;

import data.graph.Pair;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class PQFibonacciHeap2 {

    private ArrayList<NodeHeaps> rootList;
    private NodeHeaps minNode;
    private int nodesAmount;

    private class NodeHeaps {
        private int nodeKey;
        private ArrayList<NodeHeaps> childList;
        private NodeHeaps parent, left, right;
        private int childSize;
        private boolean markeD;

        public NodeHeaps(){
            nodeKey = 0;
            childList = new ArrayList<>();
            parent = null;
            left = null;
            right = null;
            childSize = 0;
            markeD = false;
        }

        public NodeHeaps(Integer nodepair, boolean marked){
            nodeKey = nodepair;
            markeD = marked;
        }

        public void addChild(NodeHeaps nodeChild){
            this.childList.add(nodeChild);
            this.childSize++;
        }

        public void removeChild(NodeHeaps eraseNode){
            this.childList.remove(eraseNode);
            this.childSize--;
        }

        public int getKey(){
            return nodeKey;
        }

        public void setKey(int key) {
            this.nodeKey = key;
        }

        public void resetChildList(NodeHeaps object){
            childList.clear();
            childList.add(object);
        }

    }

    public PQFibonacciHeap2(){
        rootList = new ArrayList<>();
        minNode = null;
        nodesAmount = 0;
    }


    public NodeHeaps getMinNode(){
        return this.minNode;
    }


    public void setMinNode(NodeHeaps newMinNode){
        this.minNode = newMinNode;
    }

    public void InsertNode(NodeHeaps node){
        if (this.minNode.equals(null)){
            this.minNode = node;
            rootList.add(node);
        }
        else{
            rootList.add(node);
            if (node.getKey() < this.minNode.getKey()){
                this.minNode = node;
            }
        }
        nodesAmount++;
    }

    public NodeHeaps extractMin(){
        //busco el minimo
        NodeHeaps minNode = getMinNode();
        if (!minNode.equals(null)){
            //Para cada hijo del minNode
            ArrayList<NodeHeaps> childs = minNode.childList;
            ArrayList<NodeHeaps> newAddsForRoot = new ArrayList<>();
            for (int i=0; i < minNode.childSize; i++){
                NodeHeaps aChild = childs.get(i);
                //Quitamos padre de hijos y agregamos hijos al root
                aChild.parent = null;
                newAddsForRoot.add(aChild);
            }

            //quitamos padre de root
            rootList.remove(minNode);
            if (rootList.size() == 0){
                setMinNode(null);
            }
            else if (getMinNode().equals(minNode.right)){
                Consolidate();
            }
            rootList.addAll(newAddsForRoot);
            nodesAmount--;
        }
        return minNode;
    }

    /*TODO: Complete
    */
    private void Consolidate() {
        ArrayList<NodeHeaps> auxRootList = new ArrayList();
        //Se inicializa array auxiliar
        for (int i=0; i < rootList.size(); i++){
            auxRootList.set(i, null);
        }

        //Para cada nodo en rootList
        for (int j=0; j < rootList.size(); j++){
            NodeHeaps nodeRoot = rootList.get(j);
            int d = nodeRoot.childSize;
            while (!auxRootList.get(d).equals(null)){
                NodeHeaps otherNode = auxRootList.get(d);
                if (nodeRoot.getKey() > otherNode.getKey()){
                    fib_heap_link(otherNode, nodeRoot);
                    auxRootList.set(d, null);
                    d++;
                }
            }
            auxRootList.set(d, nodeRoot);
        }


    }

    private void fib_heap_link(NodeHeaps otherNode, NodeHeaps nodeRoot) {
    }

    public void decreaseKey(NodeHeaps node, int key){
        if (key > node.getKey()){
            throw new RuntimeException();
        }
        node.setKey(key);
        node.resetChildList(node.parent);

        if (!node.childList.isEmpty()){
            boolean keyGreaterThanCurrent = false;
            for (int i=0; i < node.childSize; i++){
                if (node.getKey() < node.childList.get(i).getKey()){
                    keyGreaterThanCurrent = true;
                }
            }
            if (keyGreaterThanCurrent){
                Cut(node);
                CascadingCut();
            }
        }

        if (node.getKey() < minNode.getKey()){
            setMinNode(node);
        }
    }

    /*TODO: Complete
     */
    public void Cut(NodeHeaps piv){

    }

    /*TODO: Complete
     */
    public void CascadingCut(){

    }


}
