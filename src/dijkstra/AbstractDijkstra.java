package dijkstra;
import data.graph.Graph;
import java.util.ArrayList;

public abstract class AbstractDijkstra {

    protected Graph graph;

    public AbstractDijkstra(Graph graph)
    {
        this.graph = graph;
    }

    /**
     * Toma un vertice de nuestro grafo y devuelve la distancia minima
     * hacia los demas nodos del grafo
     * @param s: indica el nodo de partida
     * @return lista de distancias
     */
    public abstract ArrayList<Double> shortestPath(int s);

    public int nodesNum()
    {
        return this.graph.nodesNum();
    }
}
