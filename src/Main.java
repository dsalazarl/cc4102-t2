import data.Graph;

public class Main {

    public static void main(String[] args)
    {
        // grafo
        Graph grafoTest = new Graph(20);

        // inicialización
        for (int i = 0; i < 19; i++)
        {
            grafoTest.addEdge(i, i + 1, 1.0 / i);
        }

        grafoTest.printGraph();
    }
}
