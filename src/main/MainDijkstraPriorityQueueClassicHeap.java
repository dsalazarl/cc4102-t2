package main;

import data.graph.Graph;
import data.graph.GraphGenerator;
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
        // Polimorfismo sobre PriorityQueue
        Graph grafoide = GraphGenerator.testGraph2();
        PriorityQueue queue = new PQClassicHeap(grafoide.nodesNum());
        DijkstraPriorityQueue dpq = new DijkstraPriorityQueue(grafoide, queue);
        ArrayList<Double> minDists = dpq.shortestPath(0);
        System.out.println(minDists.get(9));
    }
}
