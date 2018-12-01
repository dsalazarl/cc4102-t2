package main;

import data.graph.Graph;
import data.graph.GraphGenerator;
import dijkstra.DijkstraArray;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        Graph grafoide = GraphGenerator.testGraph1();
        // grafoide.printGraph();
        DijkstraArray hola = new DijkstraArray(grafoide);
        ArrayList<Double> resultados = hola.shortestPath(2);
        System.out.println(resultados.get(0));
    }

}
