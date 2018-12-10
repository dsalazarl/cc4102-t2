package data.priority_queue;

import data.graph.Pair;

import java.util.ArrayList;

/**
 * Operaciones propias de una cola de prioridad.
 * Se utilizará esta interface para realizar polimorfismo al implementar el algoritmo de Dijkstra.
 */
public interface PriorityQueue {
    /**
     * Revisar si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Busca un elemento dentro de la cola.
     * @param k llave del elemento a buscar dentro de la cola.
     * @return true si encontró la llave del elemento, false en caso contrario
     */
    boolean containsKey(int k);

    /**
     * Insertar elementos en la cola de prioridad.
     * @param key la llave del elemento a insertar.
     * @param value el valor de la prioridad que tiene el elemento a insertar.
     *              a menor valor, mayor prioridad tiene.
     */
    void insert(int key, int value);

    /**
     * Sacar de la cola el nodo que tiene mayor prioridad. El nodo está representado por el Pair<nodeId, nodePriority>
     * @return la llave del nodo con mayor prioridad en la cola.
     */
    Pair<Integer, Double> extractMin();

    /**
     * Busca un elemento y si lo encuentra, actualiza el valor de su prioridad dentro de la cola.
     * @param k la llave del elemento a actualizar
     * @param value el valor de la prioridad del elemento que se desea actualizar.
     * @return true si se pudo actualizar, false en caso contrario.
     */
    boolean updatePriority(int k, int value);

    /**
     * Actualiza la distancia para la llave.
     * @param key llave del elemento al que se le quiere cambiar la prioridad. En este caso hará referencia al vértice.
     * @param priority valor de la prioridad a la cual se quiere bajar el valor de la llave.
     */
    void decreaseKey(int key, double priority);

    /**
     * Imprime en consola el largo del minHeap y su tamaño (size).
     * Con fines de debugging.
     */
    void printProp();

    /**
     * Crea el heap a partir de una lista de prioridades.
     * @param priorities lista de prioridades a partir de la cual se construirá el heap.
     * @return el objeto cola de prioridad.
     */
    PriorityQueue makeHeap(ArrayList<Double> priorities);
}
