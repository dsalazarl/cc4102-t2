package data.graph;

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
}
