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
}
