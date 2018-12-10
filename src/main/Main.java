package main;

import data.graph.Graph;
import data.graph.GraphGenerator;
import dijkstra.DijkstraArray;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        Graph hola = GraphGenerator.nGraph(3, 10);
        hola.printGraph();


    }

}
