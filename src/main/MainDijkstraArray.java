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

    // metodo para ver cuanto se demora el dijkstra con el array
    // dadas las edges
    public static void dijkstraEdgesNaive(int edges)
    {
        Graph graph = GraphGenerator.nGraph(100000, edges);

        long startTime = System.currentTimeMillis();
        DijkstraArray da = new DijkstraArray(graph);
        ArrayList<Double> resultados = da.shortestPath(0);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;
        System.out.println("Se tardó: " + elapsedTime + " milisegundos");
    }

    public static void main(String[] args)
    {
        int nodesNum = 100000;
        int edgesNum = nodesNum * 1000;
        dijkstraEdgesNaive(edgesNum);
    }
}
