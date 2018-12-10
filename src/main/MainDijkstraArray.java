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
    public static void dijkstraEdges(int edges)
    {
        Graph testeroide = GraphGenerator.nGraph(100000, edges);

        long startTime = System.currentTimeMillis();
        DijkstraArray hola = new DijkstraArray(testeroide);
        ArrayList<Double> resultados = hola.shortestPath(0);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;
        System.out.println("Se tardó: "+elapsedTime + " milisegundos");
    }

    public static void main(String[] args)
    {

    }
}
