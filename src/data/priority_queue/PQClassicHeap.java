package data.priority_queue;

import data.graph.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Clase para representar una cola de prioridad implementada mediante un heap clásico.
 */
public class PQClassicHeap implements PriorityQueue {

    // Este sera nuestra cola de prioridad
    // una lista de pares con el primer atributo el id del nodo y segundo la distancia
    private ArrayList<Pair<Integer, Double>> minHeap;

    // Tambien necesitare a priori esta cosita para guardar la posicion de cada nodo
    // en la cola de prioridad, para asi saber donde actualizar la prioridad en en el heap

    //el posNode[i] guarda la posicion en el heap del nodo 'i'
    private ArrayList<Integer> posNode;

    // Tamaño real del heap para evitar sacar basura
    private int heapSize;

    //******* METODOS ********

    // Constructor dado n nodos,
    // Setea todas sus distancias en infinito
    // menos la del nodo '0' en 0
    public PQClassicHeap(int n)
    {
        this.heapSize = n;
        this.posNode = new ArrayList<Integer>();
        this.minHeap = new ArrayList<Pair<Integer, Double>>();
        double inf = Double.POSITIVE_INFINITY;
        // las posiciones estan originales

        this.minHeap.add(0, new Pair(0, 0));

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

    // extraigo el elemento con mayor prioridad, osea el minimo
    public Pair<Integer, Double> extractMin()
    {
        // el minimo
        Pair<Integer,Double> min = this.minHeap.get(0);
        // seteo en -1 la posicion en el heap de la raiz que vamos a sacar
        this.posNode.set(min.getFirst(), -1);
        // cambio la raiz por el ultimo elemento
        this.minHeap.set(0, this.minHeap.get(this.heapSize-1));
        // seteo que el ultimo elemento ahora esta en la raiz
        this.posNode.set(this.minHeap.get(0).getFirst(),0);
        // le resto uno al largo del heap
        this.heapSize -= 1;
        // mantengo la propiedad
        this.minHeapifiy(0);
        return min;
    }

    // nueva distancia para nuestro node
    // voy a obtener a un nodo vecino y le cambiare
    // su distancia a key
    public void decreaseKey(int node, double key)
    {
        // donde esta el nodo afectado en nuestro heap
        int i = this.posNode.get(node);
        // mientras no soy la raiz y el padre es mayor  que el hijo
        // los tengo que intercambiar
        while (i > 0 && this.minHeap.get(i/2).getSecond() > this.minHeap.get(i).getSecond())
        {
            // guardamos al padre
            Pair<Integer,Double> padre = this.minHeap.get(i/2);
            // asignamos al padre el hijo
            this.minHeap.set(i/2, this.minHeap.get(i));
            // y al hijo como el padre
            this.minHeap.set(i, padre);
            // actualizo posicion de cada nodo en el heap
            this.posNode.set(node, i/2);
            this.posNode.set(padre.getFirst(), i);

            i /= 2;
        }
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

    // buildear el min heap
    public void buildMinHeap()
    {
        for (int i = this.heapSize/2; i <= 0; --i)
        {
            this.minHeapifiy(i);
        }
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }


    @Override
    public boolean containsKey(int k)
    {
        return false;
    }


    @Override
    public void insert(int key, int value)
    {

    }

    @Override
    public int pullHighestPriority() {
        return 0;
    }

    @Override
    public boolean updatePriority(int k, int value)
    {
        return false;
    }
}
