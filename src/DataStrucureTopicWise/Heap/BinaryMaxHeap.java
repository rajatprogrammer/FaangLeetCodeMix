package DataStrucureTopicWise.Heap;

//https://leetcode.com/problems/top-k-frequent-elements/
import java.util.ArrayList;

public class BinaryMaxHeap {
	private ArrayList<Integer> heap;

	public BinaryMaxHeap() {
		heap = new ArrayList<>();
	}

	// Get the index of the parent node
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// Get the index of the left child
	private int leftChild(int i) {
		return 2 * i + 1;
	}

	// Get the index of the right child
	private int rightChild(int i) {
		return 2 * i + 2;
	}

	// Insert a new element into the heap
	public void insert(int element) {
		heap.add(element);
		int current = heap.size() - 1;

		// Heapify up to maintain the max heap property
		while (current > 0 && heap.get(current) > heap.get(parent(current))) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	// Remove and return the maximum element (the root)
	public int extractMax() {
		if (heap.size() == 0) {
			throw new IllegalStateException("Heap is empty");
		}

		int max = heap.get(0);
		int lastElement = heap.remove(heap.size() - 1);

		if (heap.size() > 0) {
			heap.set(0, lastElement);
			heapify(0); // Heapify down
		}

		return max;
	}

	// Heapify down to maintain the max heap property
	private void heapify(int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int largest = i;
		if (left < heap.size() && heap.get(left) > heap.get(largest)) {
			largest = left;
		}
		if (right < heap.size() && heap.get(right) > heap.get(largest)) {
			largest = right;
		}
		if (largest != i) {
			swap(i, largest);
			heapify(largest);
		}
	}

	// Swap two elements in the heap
	private void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	// Print the heap
	public void printHeap() {
		System.out.println(heap);
	}

	public static void main(String[] args) {
		BinaryMaxHeap maxHeap = new BinaryMaxHeap();
		maxHeap.insert(10);
		maxHeap.insert(20);
		maxHeap.insert(5);
		maxHeap.insert(30);
		maxHeap.insert(25);

		System.out.println("Heap after insertion:");
		maxHeap.printHeap();

		System.out.println("Extracted max: " + maxHeap.extractMax());
		System.out.println("Extracted max: " + maxHeap.extractMax());
		System.out.println("Extracted max: " + maxHeap.extractMax());
		maxHeap.insert(-9);
		maxHeap.insert(-2);
		maxHeap.insert(30);
		System.out.println("Extracted max: " + maxHeap.extractMax());
		System.out.println("Extracted max: " + maxHeap.extractMax());
		maxHeap.insert(-2);
		maxHeap.insert(30);
		System.out.println("Extracted max: " + maxHeap.extractMax());
		System.out.println("Heap after extraction:");
		maxHeap.printHeap();
	}
}
