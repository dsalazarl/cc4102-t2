package dijkstra;
import data.Graph;
import java.util.ArrayList;

public abstract class AbstractDijkstra {

    private Graph graph;

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
    {

    }
}
