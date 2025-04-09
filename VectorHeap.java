import java.util.Vector;

/**
 * Implementación de una cola de prioridad (min-heap) basada en un Vector,
 * donde los elementos se ordenan de acuerdo con su prioridad natural
 * definida por {@code Comparable}.
 * 
 * Esta clase sigue el comportamiento de un min-heap, en el cual el elemento
 * con la mayor prioridad (el más "pequeño" según compareTo) siempre se
 * encuentra en la raíz del heap.
 *
 * @param <E> el tipo de elementos almacenados, que debe ser comparable
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    
    /** Almacena los elementos del heap. */
    protected Vector<E> data; 
    
    /**
     * Constructor por defecto. Crea un heap vacío.
     */
    public VectorHeap() {
        data = new Vector<E>();
    }
    
    /**
     * Constructor que construye un heap a partir de un vector dado.
     * 
     * @param v el vector con los elementos iniciales
     */
    public VectorHeap(Vector<E> v) {
        data = new Vector<E>(v.size()); 
        for (int i = 0; i < v.size(); i++) {
            data.add(v.get(i));
        }
        buildHeap();
    }

    /** 
     * Devuelve el índice del padre de un nodo en la posición dada.
     * @param i índice del nodo hijo
     * @return índice del nodo padre
     */
    protected int parent(int i) {
        return (i-1)/2;
    }

    /** 
     * Devuelve el índice del hijo izquierdo del nodo en la posición dada.
     * @param i índice del nodo padre
     * @return índice del hijo izquierdo
     */
    protected int left(int i) {
        return 2*i + 1;
    }

    /** 
     * Devuelve el índice del hijo derecho del nodo en la posición dada.
     * @param i índice del nodo padre
     * @return índice del hijo derecho
     */
    protected int right(int i) {
        return 2*i + 2;
    }

    /**
     * Ajusta el heap hacia arriba desde una hoja para mantener la propiedad del heap.
     * @param leaf índice de la hoja recién agregada
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }

        data.set(leaf, value);
    }

    /**
     * Ajusta el heap hacia abajo desde la raíz para mantener la propiedad del heap.
     * @param root índice de la raíz del heap
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        
        while (root < heapSize) {
            int childpos = left(root);
            
            if (childpos >= heapSize) break;
            
            if (right(root) < heapSize && 
                data.get(right(root)).compareTo(data.get(childpos)) < 0) {
                childpos = right(root);
            }
            
            if (value.compareTo(data.get(childpos)) <= 0) break;
            
            data.set(root, data.get(childpos));
            root = childpos;
        }
        
        data.set(root, value);
    }

    /**
     * Reconstruye el heap completo desde los datos actuales.
     */
    protected void buildHeap() {
        for (int i = data.size()/2 - 1; i >= 0; i--) {
            pushDownRoot(i);
        }
    }

    /**
     * Agrega un nuevo elemento al heap.
     * 
     * @param value el elemento a agregar
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Obtiene el primer elemento (de mayor prioridad) sin removerlo.
     * 
     * @return el primer elemento, o {@code null} si el heap está vacío
     */
    @Override
    public E getFirst() {
        if (isEmpty()) return null;
        return data.get(0);
    }

    /**
     * Elimina y devuelve el primer elemento (de mayor prioridad) del heap.
     * 
     * @return el elemento removido, o {@code null} si el heap está vacío
     */
    @Override
    public E remove() {
        if (isEmpty()) return null;

        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        
        if (!data.isEmpty()) {
            pushDownRoot(0);
        }
        
        return minVal;
    }

    /**
     * Devuelve la cantidad de elementos en el heap.
     * 
     * @return número de elementos almacenados
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Verifica si el heap está vacío.
     * 
     * @return {@code true} si el heap no contiene elementos
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Elimina todos los elementos del heap.
     */
    @Override
    public void clear() {
        data.clear();
    }
}
