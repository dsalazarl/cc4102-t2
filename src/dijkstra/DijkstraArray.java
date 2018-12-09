package dijkstra;

import data.graph.Graph;
import java.util.ArrayList;

public class DijkstraArray extends AbstractDijkstra {
    public DijkstraArray(Graph graph)
    {
        super(graph);
    }

    @Override
    public ArrayList<Double> shortestPath(int s, Class a) {
        // nuestro infinito
        double inf = Double.POSITIVE_INFINITY;
        // nuestro arreglo de distancias desde 's' hasta todos los nodos
        ArrayList<Double> minDists = new ArrayList<Double>();
        // arreglo de nodos que ya hemos visitado
        ArrayList<Boolean> visited = new ArrayList<Boolean>();
        // arreglo para reconstruir el camino
        ArrayList<Integer> previous = new ArrayList<Integer>();


        for (int i = 0; i < this.nodesNum(); i++ )
        {
            minDists.add(inf);
            visited.add(false);
            previous.add(null);
        }
        // nuestro nodo start con distancia = 0
        minDists.set(s, 0d);

        // Ahora vamos a visitar a todos los nodos
        for (int i = 0; i< this.nodesNum(); i++)
        {
            double minDist = inf;
            int minNode = -1;
            // buscar el minimo de los nodos no visitados para visitarlo
            for (int j = 0; j< this.nodesNum(); j++)
            {
                if (!visited.get(j) && minDists.get(j) < minDist)
                {
                    minDist = minDists.get(j);
                    minNode = j;
                }
            }
            // Ahora visitamos a minNode y lo marcamos como visitado
            visited.set(minNode, true);
            // iteramos sobre los vecinos de nuestro minNode
            for(int k = 0; k < this.graph.getEdges(minNode).size(); k++)
            {
                //vecino actual
                int neighbour = this.graph.getEdges(minNode).get(k).getFirst();
                // peso de ir desde minNode hasta el vecino
                double weight = this.graph.getEdges(minNode).get(k).getSecond();
                if (minDists.get(neighbour) > minDists.get(minNode) + weight )
                {
                    minDists.set(neighbour, minDists.get(minNode) + weight);
                    previous.set(neighbour, minNode);
                }
            }
        }

        return minDists;
    }
}
