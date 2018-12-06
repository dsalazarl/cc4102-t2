package dijkstra;

import data.graph.Graph;
import data.priority_queue.PQClassicHeap;
import data.priority_queue.PriorityQueue;

import java.util.ArrayList;

public class DijkstraPriorityQueue extends AbstractDijkstra {
    PriorityQueue pq;

    public DijkstraPriorityQueue(Graph graph, PriorityQueue queue)
    {
        super(graph);
        this.pq = queue;
    }

    @Override
    public ArrayList<Double> shortestPath(int s) {
        ArrayList<Double> dist = new ArrayList<>();
        ArrayList<Integer> previous = new ArrayList<>();
        double inf = Double.POSITIVE_INFINITY;

        for (int i = 0; i < this.graph.nodesNum(); i++)
        {
            dist.add(inf);
            previous.add(-1);
        }
        // Setear a 0 el valor del vértice especificado como origen
        dist.set(s, 0.0d);

        // Construir el heap de la cola de prioridad a partir del arreglo de distancias
        this.pq = new PQClassicHeap(dist);


        while (!pq.isEmpty())
        {

            int minNode = pq.extractMin().getFirst();
            // iteramos sobre los vecinos de nuestro minNode
            for(int k = 0; k < this.graph.getEdges(minNode).size(); k++)
            {
                //vecino actual
                int neighbour = this.graph.getEdges(minNode).get(k).getFirst();
                // peso de ir desde minNode hasta el vecino
                double weight = this.graph.getEdges(minNode).get(k).getSecond();
                double newDist = dist.get(minNode) + weight;
                if (dist.get(neighbour) > newDist)
                {
                    dist.set(neighbour, dist.get(minNode) + weight);
                    previous.set(neighbour, minNode);
                    pq.decreaseKey(neighbour, newDist);
                }
            }
        }

        return dist;
    }

}
