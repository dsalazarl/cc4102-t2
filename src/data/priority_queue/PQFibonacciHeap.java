package data.priority_queue;

import data.graph.Pair;

/**
 * Clase para representar una cola de prioridad implementada mediante un heap de Fibonacci.
 */
public class PQFibonacciHeap implements PriorityQueue {
    /**
     * Revisar si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return false;
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
     * Sacar de la cola el nodo que tiene mayor prioridad.
     *
     * @return la llave del nodo con mayor prioridad en la cola.
     */
    @Override
    public Pair<Integer, Double> extractMin() {
        return null;
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

    /**
     * Actualiza la distancia para la llave.
     *
     * @param key      llave del elemento al que se le quiere cambiar la prioridad. En este caso hará referencia al vértice.
     * @param priority valor de la prioridad a la cual se quiere bajar el valor de la llave.
     */
    @Override
    public void decreaseKey(int key, double priority) {

    }
}
