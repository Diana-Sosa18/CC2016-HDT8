import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    private VectorHeap<Integer> heap;

    @BeforeEach
    void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    void testAddAndGetFirst() {
        heap.add(10);
        heap.add(5);
        heap.add(15);

        assertEquals(5, heap.getFirst());
    }

    @Test
    void testRemove() {
        heap.add(20);
        heap.add(10);
        heap.add(30);

        assertEquals(10, heap.remove());
        assertEquals(20, heap.remove());
        assertEquals(30, heap.remove());
        assertNull(heap.remove()); 
    }

    @Test
    void testSize() {
        assertEquals(0, heap.size());
        heap.add(1);
        heap.add(2);
        assertEquals(2, heap.size());
        heap.remove();
        assertEquals(1, heap.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.add(7);
        assertFalse(heap.isEmpty());
        heap.remove();
        assertTrue(heap.isEmpty());
    }

    @Test
    void testClear() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.clear();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    void testConstructorWithVector() {
        Vector<Integer> vec = new Vector<>();
        vec.add(8);
        vec.add(3);
        vec.add(6);

        VectorHeap<Integer> heapFromVector = new VectorHeap<>(vec);
        assertEquals(3, heapFromVector.getFirst());
    }
}

