package main;

import data.graph.Graph;
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
        Graph dummyGraph = new Graph();
        PriorityQueue queue = new PQFibonacciHeap(dummyGraph.nodesNum());
        System.out.println(queue.getClass().toString());
        DijkstraPriorityQueue dpq = new DijkstraPriorityQueue(dummyGraph, queue);
        ArrayList<Double> minDists = dpq.shortestPath(0, queue.getClass());
    }
}
