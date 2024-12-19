package DataStrucureTopicWise.Heap;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap {
    private ArrayList<Integer> heap;

    // Constructor to initialize the MinHeap
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Helper method to get the parent index
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    // Helper method to get the left child index
    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    // Helper method to get the right child index
    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    // Insert a new value into the heap
    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;

        // Bubble up
        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(getParent(currentIndex))) {
            swap(currentIndex, getParent(currentIndex));
            currentIndex = getParent(currentIndex);
        }
    }

    // Extract the minimum value from the heap
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        
        int minValue = heap.get(0);
        int lastValue = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastValue);
            heapify(0);
        }

        return minValue;
    }

    // Heapify the tree at a given index
    private void heapify(int index) {
        int left = getLeftChild(index);
        int right = getRightChild(index);
        int smallest = index;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    // Get the minimum element in the heap
    public int getMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Get the size of the heap
    public int size() {
        return heap.size();
    }

    // Display the heap
    public void printHeap() {
        System.out.println(heap);
    }

    // Main method to test the MinHeap
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);

        System.out.println("MinHeap: ");
        minHeap.printHeap();

        System.out.println("Extract Min: " + minHeap.extractMin());
        minHeap.printHeap();

        System.out.println("Get Min: " + minHeap.getMin());
        minHeap.printHeap();
    }
}

