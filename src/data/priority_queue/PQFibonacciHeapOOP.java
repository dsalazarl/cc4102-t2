package data.priority_queue;

import data.NodeHeaps;
import data.graph.Pair;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class PQFibonacciHeapOOP {

    public static int MAXDEGREE = 5;
    private ArrayList<NodeHeaps> rootList;
    private ArrayList<NodeHeaps> allNodes;
    private NodeHeaps minNode;
    private int nodesAmount;


    public PQFibonacciHeapOOP(){
        rootList = new ArrayList<>();
        allNodes = new ArrayList<>();
        minNode = null;
        nodesAmount = 0;
    }


    public NodeHeaps getMinNode(){
        return this.minNode;
    }


    public void setMinNode(NodeHeaps newMinNode){
        this.minNode = newMinNode;
    }

    public void insertNode(NodeHeaps node){
        //Guardamos nodo y posicion
        allNodes.add(node.getId(), node);

        if (this.minNode == null) {
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

    public NodeHeaps searchNode(int id){
        return allNodes.get(id);
    }

    public NodeHeaps extractMin(){
        //busco el minimo
        NodeHeaps minNode = getMinNode();
        if (minNode != null){
            //Para cada hijo del minNode
            ArrayList<NodeHeaps> childs = minNode.getChildList();
            for (int i=0; i < minNode.getChildSize(); i++){
                NodeHeaps aChild = childs.get(i);
                //Quitamos padre de hijos y agregamos hijos al root
                rootList.add(aChild);
                aChild.setParent(null);
            }

            //quitamos padre de root
            rootList.remove(minNode);
            if (rootList.size() == 0){
                setMinNode(null);
            }
            else {
                NodeHeaps firstNodeInRoot = rootList.get(0);
                setMinNode(firstNodeInRoot);
                Consolidate();
            }
            nodesAmount--;
        }
        return minNode;
    }


    private void Consolidate() {
        ArrayList<NodeHeaps> auxRootList = new ArrayList<>();
        //Se inicializa array auxiliar
        for (int i=0; i < MAXDEGREE; i++){
            auxRootList.add(i, null);
        }

        //Para cada nodo en rootList
        for (int j=0; j < rootList.size(); j++){
            NodeHeaps nodeRoot = rootList.get(j);
            int d = nodeRoot.getChildSize();
            while (auxRootList.get(d) != null){
                NodeHeaps otherNode = auxRootList.get(d);
                if (nodeRoot.getKey() > otherNode.getKey()){
                    //cambiamos nodeRoot con otherNode
                    rootList.set(j, otherNode);
                    auxRootList.set(d, nodeRoot);
                }
                fib_heap_link(otherNode, nodeRoot);
                auxRootList.set(d, null);
                d++;
            }
            auxRootList.set(d, nodeRoot);
        }
        minNode = null;
        for (int k=0; k < rootList.size() ; k++){
            if (auxRootList.get(k) !=  null){
                NodeHeaps newNode = auxRootList.get(k);
                if (minNode == null){
                    //Creamos rootlist y agregamos elemento de auxRoot
                    rootList.clear();
                    rootList.add(newNode);

                    minNode = newNode;
                }
                else {
                    rootList.add(newNode);
                    if (newNode.getKey() < minNode.getKey()){
                        minNode = newNode;
                    }
                }
            }
        }


    }

    private void fib_heap_link(NodeHeaps otherNode, NodeHeaps nodeRoot) {
        //Quitamos otherNode de rootList
        rootList.remove(otherNode);

        //Hacemos a otherNode hijo de nodeRoot
        nodeRoot.addChild(otherNode);
        otherNode.setMarkeD(false);


    }

    public void decreaseKey(NodeHeaps node, int key){
        if (key > node.getKey()){
            throw new RuntimeException();
        }
        node.setKey(key);
        NodeHeaps y = node.getParent();

        if (y != null && node.getKey() < y.getKey()){
            Cut(node, y);
            CascadingCut(y);
        }

        if (node.getKey() < minNode.getKey()){
            setMinNode(node);
        }
    }

    public void Cut(NodeHeaps x, NodeHeaps y){
        y.removeChild(x);
        y.setChildSize(y.getChildSize() - 1);

        //Agregamos x a rootList
        rootList.add(x);

        x.setParent(null);
        x.setMarkeD(false);
    }

    public void CascadingCut(NodeHeaps y){
        NodeHeaps z = y.getParent();
        if (z != null){
            if (!y.isMarkeD()){
                y.setMarkeD(true);
            }
            else{
                Cut(y, z);
                CascadingCut(z);
            }
        }
    }


}
