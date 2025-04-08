
public interface PriorityQueue<E extends Comparable<E>> {
    void add(E value);
    
    E getFirst();
    
    E remove();

    int size();
    
    boolean isEmpty();
    
    void clear();
}