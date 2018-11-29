package data;

import java.util.ArrayList;

/**
 * Clase para representar grafos.
 *
 * graph["i"] devolverá un arraylist "a" que corresponderá a una lista de pares
 * de los cuales se puede llegar desde el nodo "i" hasta el nodo a[m].first,
 * con peso a[m].second para cualquier 0 <= m < graph["i"].size
 *
 * La clase dijkstra usará esta representacion.
 */
public class Graph
{
    private ArrayList< ArrayList< Pair<Integer, Double> > > graph;

    /**
     * Constructor de la clase. Solamente inicializa el grafo con una lista vacía.
     */
    public Graph()
    {
        this.graph = new ArrayList<>();
    }

    /**
     * Constructor de la clase. Inicializa la estructura dejando listas aristas vacías por cada nodo
     * @param numNodes cantidad de nodos que tendrá el grafo. Por simplicidad,
     *                 las ids de los nodos estarán numeradas de 1 hasta numNodes.
     */
    public Graph(int numNodes)
    {
        this();
        for (int i = 0; i < numNodes; i++)
        {
            ArrayList<Pair<Integer, Double>> inner = new ArrayList<>();
            this.graph.add(i, inner);
        }
    }

    /**
     * Dado un nodo "desde" y otro de "llegada" y un peso "weight" se añade
     * una arista desde "desde" hasta "llegada" con peso "weight" a nuestro grafo.
     * @param idNodeFrom nodo de origen.
     * @param idNodeTo nodo de llegada.
     * @param weight peso/costo de la arista que va desde el nodo de origen hacia el nodo de llegada.
     */
    public void addEdge(int idNodeFrom, int idNodeTo, double weight)
    {
        Pair<Integer, Double> edge = new Pair(idNodeTo, weight);
        this.graph.get(idNodeFrom).add(edge);
    }

    /**
     * Imprime una descripcion del grafo a la salida estandar.
     */
    public void printGraph()
    {
        System.out.println("***Lista de aristas del grafo***");
        for (int i = 0; i < this.graph.size(); i++)
        {
            System.out.println("Para el nodo: " + i);
            ArrayList<Pair<Integer, Double>> nodoI = this.graph.get(i);

            for (int j = 0; j < nodoI.size(); j++)
            {
                System.out.print("   Hacia el nodo: " + nodoI.get(j).getFirst());
                System.out.println(" Con peso: " + nodoI.get(j).getSecond());
            }
        }
    }

    /**
     * Obtener lista de aristas que salen inmediatamente a partir de un nodo.
     * @param node nodo de origen a partir del cual se desea obtener las aristas que salen de él.
     * @return lista de aristas que salen de un nodo, expresada como una lista de pares con el
     *         nodo de llegada y el peso/costo asociado.
     */
    public ArrayList<Pair<Integer, Double>> getEdges(int node)
    {
        return this.graph.get(node);
    }
}
