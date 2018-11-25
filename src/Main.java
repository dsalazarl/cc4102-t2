import data.Graph;
import data.Pair;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {

        // grafo
        Graph grafoTest = new Graph(20);

        // inicializar
        for (int i = 0; i < 19; i++)
        {
            grafoTest.addEdge(i, i + 1, 1.0 / i);
        }

        grafoTest.graphOut();
    }
}
