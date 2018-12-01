package data.priority_queue;

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
     * Sacar de la cola el elemento que tiene mayor prioridad.
     *
     * @return la llave del elemento con mayor prioridad en la cola.
     */
    @Override
    public int pullHighestPriority() {
        return 0;
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
