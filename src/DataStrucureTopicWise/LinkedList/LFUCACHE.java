package DataStrucureTopicWise.LinkedList;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair;

//https://leetcode.com/problems/lfu-cache/description/
public class LFUCACHE {
	
    // key: original key, value: frequency and original value.
    private Map<Integer, Pair<Integer, Integer>> cache;
    // key: frequency, value: All keys that have the same frequency.
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int minf;
    private int capacity;

    private

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 
		void insert(int key, int frequency, int value) {
	        cache.put(key, new Pair<>(frequency, value));
	        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
	        frequencies.get(frequency).add(key);
	    }

	    public LFUCache(int capacity) {
	        cache = new HashMap<>();
	        frequencies = new HashMap<>();
	        minf = 0;
	        this.capacity = capacity;
	    }

	    public int get(int key) {
	        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
	        if (frequencyAndValue == null) {
	            return -1;
	        }
	        final int frequency = frequencyAndValue.getKey();
	        final Set<Integer> keys = frequencies.get(frequency);
	        keys.remove(key);
	        if (keys.isEmpty()) {
	            frequencies.remove(frequency);

	            if (minf == frequency) {
	                ++minf;
	            }
	        }
	        final int value = frequencyAndValue.getValue();
	        insert(key, frequency + 1, value);
	        return value;
	    }

	    public void put(int key, int value) {
	        if (capacity <= 0) {
	            return;
	        }
	        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
	        if (frequencyAndValue != null) {
	            cache.put(key, new Pair<>(frequencyAndValue.getKey(), value));
	            get(key);
	            return;
	        }
	        if (capacity == cache.size()) {
	            final Set<Integer> keys = frequencies.get(minf);
	            final int keyToDelete = keys.iterator().next();
	            cache.remove(keyToDelete);
	            keys.remove(keyToDelete);
	            if (keys.isEmpty()) {
	                frequencies.remove(minf);
	            }
	        }
	        minf = 1;
	        insert(key, 1, value);
	    }

}
