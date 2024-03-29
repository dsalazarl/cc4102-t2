package data.graph;
import java.util.concurrent.ThreadLocalRandom;

public class GraphGenerator {

    public static Graph testGraph1()
    {
        Graph grafito = new Graph(3);
        grafito.addEdge(0,2,1000);
        grafito.addEdge(0, 1, 1);

        grafito.addEdge(1,2,1);
        grafito.addEdge(1, 0, 1);

        grafito.addEdge(2, 0, 1000);
        grafito.addEdge(2, 1, 1);

        return grafito;
    }

    public static Graph testGraph2()
    {
        Graph riley = new Graph(10);

        riley.addEdge(0, 7, 2);
        riley.addEdge(0, 1, 10);
        riley.addEdge(0, 2, 3);

        riley.addEdge(7, 8, 2);
        riley.addEdge(8, 9, 30);

        riley.addEdge(1, 7, 1);
        riley.addEdge(1, 2, 5);

        riley.addEdge(2, 4, 4);
        riley.addEdge(2, 3, 15);

        riley.addEdge(4, 5, 7);
        riley.addEdge(5, 6, 2);
        riley.addEdge(6, 9, 3);

        riley.addEdge(3, 9, 40);

        return riley;
    }

    public static Graph nGraph(int nodes, int edges)
    {
        // generalmente 100.000 nodos, del 0 hata el 99.999
        Graph sasha = new Graph(nodes);

        // primeras 99.999 aristas para asegurar conectividad
        // del primer nodo a todos los demas
        for (int i = 0; i < nodes-1; i++)
        {
            sasha.addEdge(i, i+1, Math.random());
        }

        // ahora recibiremos 10*nodes, 100*nodes o 1000*nodes edges
        // y añadiremos todas las aristas "extra"
        for (int j = 0; j < edges; j++)
        {
            // nodo al azar de inicio
            int nodoInicio = ThreadLocalRandom.current().nextInt(0, nodes);
            // nod al azar de llegada
            int nodoLlegada =  ThreadLocalRandom.current().nextInt(0, nodes);

            // si los dos nodos son iguales cambio el de llegada
            while(nodoInicio == nodoLlegada)
            {
                nodoLlegada =  ThreadLocalRandom.current().nextInt(0, nodes);
            }

            // añadimos la arista con un peso random entre 0 y 1
            sasha.addEdge(nodoInicio, nodoLlegada, Math.random());
        }

        return sasha;
    }
}
