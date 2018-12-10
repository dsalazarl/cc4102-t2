package main;

import data.graph.Graph;
import data.graph.GraphGenerator;
import data.priority_queue.PQClassicHeap;
import data.priority_queue.PriorityQueue;
import dijkstra.DijkstraArray;
import dijkstra.DijkstraPriorityQueue;

import java.util.ArrayList;



/**
 * Clase en la cual se va a testear el algoritmo de Dijstra
 * mediante PriorityQueue implementado con un Heap clásico.
 */
public class MainDijkstraPriorityQueueClassicHeap {

    public static void dijkstraEdgesPQ(int edges)
    {
        Graph grafiroide = GraphGenerator.nGraph(100000, edges);

        long startTime = System.currentTimeMillis();
        PriorityQueue queue = new PQClassicHeap(grafiroide.nodesNum());
        DijkstraPriorityQueue dpq = new DijkstraPriorityQueue(grafiroide, queue);
        ArrayList<Double> minDists = dpq.shortestPath(0);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;
        System.out.println("Se tardó: "+elapsedTime + " milisegundos");

    }

    // Test
    public static void dummyDijkstraTest()
    {
        Graph grafoide = GraphGenerator.testGraph2();
        PriorityQueue queue = new PQClassicHeap(grafoide.nodesNum());
        DijkstraPriorityQueue dpq = new DijkstraPriorityQueue(grafoide, queue);
        ArrayList<Double> minDists = dpq.shortestPath(0);
        for(int i=0; i < minDists.size(); i++)
            System.out.println("Distancia mínima entre el nodo 0 y el nodo " + i + " es: " + minDists.get(i));
    }


    public static void main(String[] args)
    {
        dijkstraEdgesPQ(10000000);
    }
}
