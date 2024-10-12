package DataStrucureTopicWise.LinkedList;

import java.util.HashMap;
//
public class LRUCACHE {
	 class Node
    {
        int value;
        Node prev;
        Node next;
        Node(int prop){
            this.value = prop;
            this.next = null;
            this.prev = null;
        }
    }
	   int totalCap = 0;
	    HashMap<Integer,Node> hs = new HashMap<>();
	    Node head = null;
	    Node last = null;
	    Node ptr = null;
	public LRUCACHE(int i) {
			this.totalCap  = i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCACHE ob1 = new LRUCACHE(2);
		ob1.put(1, 0);
		ob1.put(2,2);
		System.out.print(ob1.get(1));
		ob1.put(3,3);
		System.out.print(ob1.get(2));
		ob1.put(4,4);
		System.out.print(ob1.get(1));
		System.out.print(ob1.get(3));
		System.out.print(ob1.get(4));
	}
	public int get(int key) {
        if(hs.containsKey(key)){
            Node temp = hs.get(key);
            if(temp.prev!=null && temp.next!=null){
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
            }
            else if(temp.prev!=null  && temp.next==null){
                last =  temp.prev;
                temp.prev = null;
                head.prev = temp;
                temp.next = head;
                head = temp;
            }
            return temp.value;
        }else{
            return -1;
        }
    }
	public void put(int key, int value) {
        if(hs.size()>=totalCap){
        	hs.remove(last.value);
            last = last.prev;
            last.next = null;
            Node node = new Node(value);
            head.prev = node;
            node.next = head;
            head = node;
            hs.put(key,node);
        }else{
            if(head==null){
                Node node = new Node(value);
                hs.put(key,node);
                head=node;
                last=node;
                ptr = node;
            }else{
                Node node = new Node(value);
                head.prev = node;
                node.next = head;
                last = head;
                head = node;
                last.prev = node;
                hs.put(key,node);
            }
        }
    } 
}

