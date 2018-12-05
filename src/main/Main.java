package main;

import data.graph.Graph;
import data.graph.GraphGenerator;
import dijkstra.DijkstraArray;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {

        ArrayList<Integer> algo = new ArrayList<Integer>();
        for (int i = 0; i<20 ; ++i)
        {
            algo.add(i, i);
        }

        for (int i = 0; i < algo.size(); ++i)
        {
            System.out.print(algo.get(i)+ "  ");
        }
        Graph grafoide = GraphGenerator.testGraph1();
        // grafoide.printGraph();
        DijkstraArray hola = new DijkstraArray(grafoide);
        ArrayList<Double> resultados = hola.shortestPath(2);
        System.out.println(resultados.get(0));
    }

}
