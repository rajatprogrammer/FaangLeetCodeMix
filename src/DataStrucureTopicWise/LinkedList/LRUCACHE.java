package DataStrucureTopicWise.LinkedList;

import java.util.HashMap;
import java.util.Map;
//
public class LRUCACHE {
	 private static class Node {
	        int key, value;
	        Node prev, next;
	        
	        Node(int key, int value) {
	            this.key = key;
	            this.value = value;
	        }
	    }
	    
	    private final int capacity;
	    private final Map<Integer, Node> cache;
	    private final Node head, tail;
	    
	    public LRUCACHE(int capacity) {
	        this.capacity = capacity;
	        this.cache = new HashMap<>(capacity);
	        
	        head = new Node(0, 0);
	        tail = new Node(0, 0);
	        head.next = tail;
	        tail.prev = head;
	    }
	    
	    private void remove(Node node) {
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	    }
	    
	    private void insert(Node node) {
	        node.next = head.next;
	        node.prev = head;
	        head.next.prev = node;
	        head.next = node;
	    }
	    
	    public int get(int key) {
	        if (!cache.containsKey(key)) return -1;
	        Node node = cache.get(key);
	        remove(node);
	        insert(node);
	        return node.value;
	    }
	    
	    public void put(int key, int value) {
	        if (cache.containsKey(key)) {
	            remove(cache.get(key));
	        }
	        if (cache.size() == capacity) {
	            cache.remove(tail.prev.key);
	            remove(tail.prev);
	        }
	        Node node = new Node(key, value);
	        insert(node);
	        cache.put(key, node);
	    }
	    
	    public void display() {
	        Node temp = head.next;
	        while (temp != tail) {
	            System.out.print(temp.key + "=" + temp.value + " ");
	            temp = temp.next;
	        }
	        System.out.println();
	    }
	    
	    public static void main(String[] args) {
	    	LRUCACHE lru = new LRUCACHE(3);
	        lru.put(1, 10);
	        lru.put(2, 20);
	        lru.put(3, 30);
	        lru.display(); // 3=30 2=20 1=10
	        
	        lru.get(1); // Accessing 1
	        lru.put(4, 40); // Evicts 2 (Least Recently Used)
	        lru.display(); // 4=40 1=10 3=30
	    }
}

