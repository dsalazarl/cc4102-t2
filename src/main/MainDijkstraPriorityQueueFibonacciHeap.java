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
    public static void main(String[] args) {
        // Polimorfismo sobre PriorityQueue
        Graph dummyGraph = GraphGenerator.testGraph2();
        PriorityQueue queue = new PQFibonacciHeap(dummyGraph.nodesNum());
        DijkstraPriorityQueue dpq = new DijkstraPriorityQueue(dummyGraph, queue);
        ArrayList<Double> minDists = dpq.shortestPath(0, queue.getClass());
        for(int i=0; i < minDists.size(); i++)
            System.out.println("Distancia mínima entre el nodo 0 y el nodo " + i + " es: " + minDists.get(i));
    }
}
