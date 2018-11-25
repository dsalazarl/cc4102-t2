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

    // Imprime una descripcion de nuestro grafo a la salida estandar
    public void graphOut()
    {
        System.out.println("***Lista de aristas del grafo***");
        for (int i = 0; i < this.graph.size(); i++)
        {

            System.out.println("Para el nodo: " +i);
            ArrayList<Pair<Integer, Double>> nodoI = this.graph.get(i);

            for (int j = 0; j < nodoI.size(); j++)
            {

                System.out.print("   Hacia el nodo: "+nodoI.get(j).getFirst());
                System.out.println(" Con peso: "+nodoI.get(j).getSecond());
            }
        }
    }

    // DEVUELVE LA LISTA DE ARISTAS (pairs) A LAS QUE EL NODO "node" puede llegar
    public ArrayList<Pair<Integer, Double>> getEdges(int node)
    {
        return this.graph.get(node);
    }
}
