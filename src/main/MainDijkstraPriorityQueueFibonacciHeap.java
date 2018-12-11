package main;

import data.graph.Graph;
import data.graph.GraphGenerator;
import data.priority_queue.PQFibonacciHeap;
import data.priority_queue.PriorityQueue;
import dijkstra.DijkstraPriorityQueue;

import java.util.ArrayList;

/**
 * Clase en la cual se va a testear el algoritmo de Dijstra
 * mediante PriorityQueue implementado con un Heap de Fibonacci.
 */
public class MainDijkstraPriorityQueueFibonacciHeap {

    public static void dijkstraEdgesPQ(int edges)
    {
        Graph graph = GraphGenerator.nGraph(100000, edges);

        long startTime = System.currentTimeMillis();
        // Polimorfismo sobre PriorityQueue
        PriorityQueue fibonacciHeap = new PQFibonacciHeap(graph.nodesNum());
        DijkstraPriorityQueue dpq = new DijkstraPriorityQueue(graph, fibonacciHeap);
        ArrayList<Double> minDists = dpq.shortestPath(0);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;
        System.out.println("Se tardó: "+elapsedTime + " milisegundos");

    }

    public static void main(String[] args)
    {
        int nodesNum = 100000;
        int edgesNum = nodesNum * 1000;
        dijkstraEdgesPQ(edgesNum);
    }
}
