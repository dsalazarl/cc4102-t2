package dijkstra;

import data.Graph;

public abstract class AbstractDijkstra {

    private Graph graph;

    public AbstractDijkstra(Graph graph)
    {
        this.graph = graph;
    }

    public abstract double shortestPath();
}
