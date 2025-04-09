/**
 * Una interfaz genérica que define los métodos esenciales para una cola de prioridad.
 * 
 * Los elementos de la cola deben implementar la interfaz {@code Comparable<E>}
 * para que puedan ser ordenados de acuerdo a su prioridad natural.
 *
 * @param <E> el tipo de elementos en la cola, que debe ser comparable consigo mismo
 */
public interface PriorityQueue<E extends Comparable<E>> {

    /**
     * Agrega un elemento a la cola de prioridad.
     * 
     * @param value el elemento que se va a agregar
     */
    void add(E value);

    /**
     * Devuelve el primer elemento de la cola de prioridad sin removerlo.
     * 
     * @return el primer elemento según su prioridad
     */
    E getFirst();

    /**
     * Elimina y devuelve el primer elemento de la cola de prioridad.
     * 
     * @return el primer elemento removido
     */
    E remove();

    /**
     * Devuelve la cantidad de elementos en la cola de prioridad.
     * 
     * @return el número de elementos en la cola
     */
    int size();

    /**
     * Verifica si la cola de prioridad está vacía.
     * 
     * @return {@code true} si la cola está vacía, {@code false} en caso contrario
     */
    boolean isEmpty();

    /**
     * Elimina todos los elementos de la cola de prioridad.
     */
    void clear();
}
