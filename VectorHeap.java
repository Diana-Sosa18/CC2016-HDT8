import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data; 
    

    public VectorHeap() {
        data = new Vector<E>();
    }
    
    public VectorHeap(Vector<E> v) {
        data = new Vector<E>(v.size()); 
        for (int i = 0; i < v.size(); i++) {
            data.add(v.get(i));
        }
        buildHeap();
    }
    
    protected int parent(int i) {
        return (i-1)/2;
    }
    
    protected int left(int i) {
        return 2*i + 1;
    }
    
    protected int right(int i) {
        return 2*i + 2;
    }
    
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
    
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        
        while (root < heapSize) {
            int childpos = left(root);
            
            if (childpos >= heapSize) {
                break;
            }
            
            if (right(root) < heapSize && 
                data.get(right(root)).compareTo(data.get(childpos)) < 0) {
                childpos = right(root);
            }
            
            if (value.compareTo(data.get(childpos)) <= 0) {
                break;
            }
            
            data.set(root, data.get(childpos));
            root = childpos;
        }
        
        data.set(root, value);
    }
    
    protected void buildHeap() {
        for (int i = data.size()/2-1; i >= 0; i--) {
            pushDownRoot(i);
        }
    }
    
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size()-1);
    }
    
    @Override
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return data.get(0);
    }
    
    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        
        E minVal = data.get(0);
        
        data.set(0, data.get(data.size()-1));
        data.remove(data.size()-1);
        
        if (data.size() > 0) {
            pushDownRoot(0);
        }
        
        return minVal;
    }
    
    @Override
    public int size() {
        return data.size();
    }
    
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    @Override
    public void clear() {
        data.clear();
    }
}