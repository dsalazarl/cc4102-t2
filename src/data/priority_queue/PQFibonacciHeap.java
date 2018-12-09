package data.priority_queue;

import data.graph.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase para representar una cola de prioridad implementada mediante un heap de Fibonacci.
 */
public class PQFibonacciHeap implements PriorityQueue {


    // Este sera nuestra cola de prioridad
    // una lista de pares con el primer atributo el id del nodo y segundo la distancia
    private ArrayList<Pair<Integer, Double>> minHeap;

    //Diccionario con la lista de pares hijos para cada nodo (id)
    private HashMap<Integer, ArrayList<Pair<Integer, Double>>> childList;

    // Tambien necesitare a priori esta cosita para guardar la posicion de cada nodo
    // en la cola de prioridad, para asi saber donde actualizar la prioridad en el heap

    //el posNode[i] guarda la posicion en el heap del nodo 'i'
    private ArrayList<Integer> posNode;

    // Tamaño real del heap para evitar sacar basura
    private int heapSize;

    /**
     * Constructor para setear valores iniciales, sin construir fibonacci heap
     *
     * @param n tamaño de arreglo de prioridades
     */
    public PQFibonacciHeap(int n) {
        this.heapSize = n;
        this.posNode = new ArrayList<>();
        this.minHeap = new ArrayList<>();
        this.childList = new HashMap<>();
    }

    public PQFibonacciHeap(ArrayList priorities) {
        this(priorities.size());
        for (int i = 0; i < this.heapSize; i++)
        {
            this.minHeap.add(new Pair(i, priorities.get(i)));
            posNode.add(i);
        }

        this.buildMinHeap();
    }

    public PQFibonacciHeap(int n, boolean bla)
    {
        this.heapSize = n;
        this.posNode = new ArrayList<>();
        this.minHeap = new ArrayList<>();
        double inf = Double.POSITIVE_INFINITY;
        // las posiciones estan originales

        this.minHeap.add(0, new Pair(0, 0d));
        this.posNode.add(0, 0);

        for (int i = 1; i < n; i++)
        {
            Pair<Integer, Double> node = new Pair(i, inf);
            posNode.add(i, i);
            minHeap.add(i, node);
        }

        this.buildMinHeap();
    }

    // devuelve el mayor valor de la cola de prioridad, el nodo y su distancia como par
    public Pair<Integer, Double> heapMin()
    {
        return this.minHeap.get(0);
    }


    /**
     * Sacar de la cola el nodo que tiene mayor prioridad.
     *
     * @return la llave del nodo con mayor prioridad en la cola.
     */
    @Override
    public Pair<Integer, Double> extractMin() {
        // el minimo
        Pair<Integer,Double> min = heapMin();
        int childsOfMin = childList.get(min.getFirst()).size();

        if (!min.equals(null)){
            for (int i=0; i < childsOfMin; i++){

            }
        }
    }


    /**
     * Actualiza la distancia para la llave.
     *
     * @param key      llave del elemento al que se le quiere cambiar la prioridad. En este caso hará referencia al vértice.
     * @param priority valor de la prioridad a la cual se quiere bajar el valor de la llave.
     */
    @Override
    public void decreaseKey(int key, double priority) {
        // donde esta el nodo afectado en nuestro heap
        int i = this.posNode.get(key);
    }

    private void minHeapifiy(int i)
    {
        // los dos hijos
        int left = (2*i) +1;
        int right = (2*i)+ 2;
        boolean flag = false;
        int lesser;
        // si el hijo izquierdo es menor que nuestro nodo en i
        if (left < this.heapSize && this.minHeap.get(i).getSecond() > this.minHeap.get(left).getSecond())
        {
            lesser = left;
        }
        else
        {
            lesser = i;
        }
        // si el hijo derecho es menor
        if (right < this.heapSize && lesser > this.minHeap.get(right).getSecond())
        {
            lesser = right;
            flag = true;
        }
        // si alguno de los hijos era menor
        if (lesser != i)
        {
            // el derecho
            if (flag)
            {
                Pair<Integer, Double> hijoD = this.minHeap.get(right);
                int poshijoD = this.posNode.get(hijoD.getFirst());

                Pair<Integer, Double> nodoi = this.minHeap.get(i);
                int posnodoI = this.posNode.get(nodoi.getFirst());

                // cambio en el heap
                this.minHeap.set(right, nodoi);
                this.minHeap.set(i, hijoD);
                // cambio en las posiciones
                this.posNode.set(hijoD.getFirst(), posnodoI);
                this.posNode.set(nodoi.getFirst(), poshijoD);
            }
            // el izquierdo
            else
            {
                Pair<Integer, Double> hijoI = this.minHeap.get(left);
                int poshijoI = this.posNode.get(hijoI.getFirst());

                Pair<Integer, Double> nodoi = this.minHeap.get(i);
                int posnodoI = this.posNode.get(nodoi.getFirst());

                // cambio en el heap
                this.minHeap.set(left, nodoi);
                this.minHeap.set(i, hijoI);
                // cambio en las posiciones
                this.posNode.set(hijoI.getFirst(), posnodoI);
                this.posNode.set(nodoi.getFirst(), poshijoI);
            }
            this.minHeapifiy(lesser);
        }

    }


    // construir el min heap
    public void buildMinHeap()
    {
        for (int i = this.heapSize/2; i >= 0; --i)
        {
            this.minHeapifiy(i);
        }
    }

    public void cut(int nodo){

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
