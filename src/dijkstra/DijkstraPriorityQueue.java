package dijkstra;

import data.graph.Graph;
import data.priority_queue.PriorityQueue;

import java.util.ArrayList;

public class DijkstraPriorityQueue extends AbstractDijkstra {
    private PriorityQueue queue;

    public DijkstraPriorityQueue(Graph graph, PriorityQueue queue) {
        super(graph);
        this.queue = queue;
    }

    @Override
    public ArrayList<Double> shortestPath(int s) {
        return null;
    }

}
