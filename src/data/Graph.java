package data;

import java.util.ArrayList;

// Clase del grafo, aqui se representara un grafo.
// La clase dijkstra usara esta representacion

/* graph["i"] devolvera un arraylist "a" que correspondera
* a una lista de pares de los cuales se puede llegar desde el nodo
* "i" hasta el nodo a[m].first con peso a[m].second para cualquier
*  0 <= m < graph["i"].size
*/
public class Graph
{
    // representacion del grafo
    private ArrayList< ArrayList< Pair<Integer, Double> > > graph;

    // Empty arraylist
    public Graph()
    {
        this.graph = new ArrayList< ArrayList< Pair<Integer, Double> >>();
    }

    // Con numero de nodos descrito
    public Graph(int numNodes)
    {
        this.graph = new ArrayList< ArrayList< Pair<Integer, Double> >>(numNodes);
        for (int i = 0; i < numNodes; i++)
        {
            ArrayList<Pair<Integer, Double>> inner = new ArrayList<Pair<Integer,Double>>();
            this.graph.add(i, inner);
        }
    }

    // Dado un nodo "desde" y otro de "llegada" y un peso "weight" se añade
    // una arista desde "desde" hasta "llegada" con peso "weight"
    // a nuestro grafo
    public void addEdge(int idNodeFrom, int idNodeTo, double weight)
    {
        Pair<Integer, Double> edge = new Pair(idNodeTo, weight);
        this.graph.get(idNodeFrom).add(edge);
    }
}
