package main;

import data.graph.Graph;
import data.graph.GraphGenerator;
import dijkstra.DijkstraArray;

import java.util.ArrayList;

/**
 * Clase en la cual se va a testear el algoritmo de Dijstra
 * mediante implementación con Array.
 */
public class MainDijkstraArray {
    public static void main(String[] args)
    {
        Graph grafoide = GraphGenerator.nGraph(4, 4);
        grafoide.printGraph();
        DijkstraArray hola = new DijkstraArray(grafoide);
        ArrayList<Double> resultados = hola.shortestPath(0);
        System.out.println(resultados.get(3));
    }
}
