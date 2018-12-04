package main;

import data.graph.Graph;
import data.priority_queue.PQClassicHeap;
import data.priority_queue.PriorityQueue;
import dijkstra.DijkstraPriorityQueue;

import java.util.ArrayList;

/**
 * Clase en la cual se va a testear el algoritmo de Dijstra
 * mediante PriorityQueue implementado con un Heap clásico.
 */
public class MainDijkstraPriorityQueueClassicHeap {
    public static void main(String[] args) {
        // Ejemplo de polimorfismo sobre PrioriQueue
        Graph dummyGraph = new Graph();
        PriorityQueue queue = new PQClassicHeap(12);
        DijkstraPriorityQueue dpq = new DijkstraPriorityQueue(dummyGraph, queue);
        ArrayList<Double> minDists = dpq.shortestPath(0);
    }
}