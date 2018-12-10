package data.priority_queue;

import data.NodeHeaps;
import data.graph.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import data.priority_queue.PQFibonacciHeap2;
import org.w3c.dom.Node;

/**
 * Clase para representar una cola de prioridad implementada mediante un heap de Fibonacci.
 */
public class PQFibonacciHeap implements PriorityQueue {


    // Este sera nuestra cola de prioridad
    // una lista de pares con el primer atributo el id del nodo y segundo la distancia
    private ArrayList<Pair<Integer, Double>> minHeap;

    // Tambien necesitare a priori esta cosita para guardar la posicion de cada nodo
    // en la cola de prioridad, para asi saber donde actualizar la prioridad en el heap

    //el posNode[i] guarda la posicion en el heap del nodo 'i'
    private ArrayList<Integer> posNode;

    // Tamaño real del heap para evitar sacar basura
    private int heapSize;

    private PQFibonacciHeap2 pqFibonacci;

    /**
     * Constructor para setear valores iniciales, sin construir fibonacci heap
     *
     * @param n tamaño de arreglo de prioridades
     */
    public PQFibonacciHeap(int n) {
        this.heapSize = n;
        this.posNode = new ArrayList<>();
        this.minHeap = new ArrayList<>();
        this.pqFibonacci = new PQFibonacciHeap2();
    }

    public PQFibonacciHeap(ArrayList priorities) {
        this(priorities.size());
        for (int i = 0; i < this.heapSize; i++)
        {
            NodeHeaps newNode = new NodeHeaps(i, (double) priorities.get(i));
            pqFibonacci.insertNode(newNode);

        }

    }


    // devuelve el mayor valor de la cola de prioridad, el nodo y su distancia como par
    public Pair<Integer, Double> heapMin()
    {
        return pqFibonacci.getMinNode().nodeToPair();
    }


    /**
     * Sacar de la cola el nodo que tiene mayor prioridad.
     *
     * @return la llave del nodo con mayor prioridad en la cola.
     */
    @Override
    public Pair<Integer, Double> extractMin() {
        // el minimo
        NodeHeaps minNode = pqFibonacci.extractMin();

        return minNode.nodeToPair();
    }


    /**
     * Actualiza la distancia para la llave.
     *
     * @param key      llave del elemento al que se le quiere cambiar la prioridad. En este caso hará referencia al vértice.
     * @param priority valor de la prioridad a la cual se quiere bajar el valor de la llave.
     */
    @Override
    public void decreaseKey(int key, double priority) {
        NodeHeaps actualNode = pqFibonacci.searchNode(key);
        pqFibonacci.decreaseKey(actualNode, key);
    }


    public void printProp() {
        System.out.println("Largo minheap: " + this.minHeap.size());
        System.out.println("Largo heapsize: " + this.heapSize);
    }

    /**
     * Revisar si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    /**
     * Busca un elemento dentro de la cola.
     *
     * @param k llave del elemento a buscar dentro de la cola.
     * @return true si encontró la llave del elemento, false en caso contrario
     */
    @Override
    public boolean containsKey(int k) {
        return false;
    }

    /**
     * Insertar elementos en la cola de prioridad.
     *
     * @param key   la llave del elemento a insertar.
     * @param value el valor de la prioridad que tiene el elemento a insertar.
     */
    @Override
    public void insert(int key, int value) {

    }

    /**
     * Busca un elemento y si lo encuentra, actualiza el valor de su prioridad dentro de la cola.
     *
     * @param k     la llave del elemento a actualizar
     * @param value el valor de la prioridad del elemento que se desea actualizar.
     * @return true si se pudo actualizar, false en caso contrario.
     */
    @Override
    public boolean updatePriority(int k, int value) {
        return false;
    }

}
