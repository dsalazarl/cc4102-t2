package data.priority_queue;

/**
 * Operaciones propias de una cola de prioridad.
 * Se utilizará esta interface para realizar polimorfismo al implementar el algoritmo de Dijkstra.
 */
public interface PriorityQueue {
    /**
     * Revisar si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty();

    /**
     * Busca un elemento dentro de la cola.
     * @param k llave del elemento a buscar dentro de la cola.
     * @return true si encontró la llave del elemento, false en caso contrario
     */
    public boolean containsKey(int k);

    /**
     * Insertar elementos en la cola de prioridad.
     * @param key la llave del elemento a insertar.
     * @param value el valor de la prioridad que tiene el elemento a insertar.
     *              a menor valor, mayor prioridad tiene.
     */
    public void insert(int key, int value);

    /**
     * Sacar de la cola el elemento que tiene mayor prioridad.
     * @return la llave del elemento con mayor prioridad en la cola.
     */
    public int pullHighestPriority();

    /**
     * Busca un elemento y si lo encuentra, actualiza el valor de su prioridad dentro de la cola.
     * @param k la llave del elemento a actualizar
     * @param value el valor de la prioridad del elemento que se desea actualizar.
     * @return true si se pudo actualizar, false en caso contrario.
     */
    public boolean updatePriority(int k, int value);

}
