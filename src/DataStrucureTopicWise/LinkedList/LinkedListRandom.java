package DataStrucureTopicWise.LinkedList;

import java.util.HashMap;
//https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class LinkedListRandom {
	
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> hs = new HashMap<>();
	}
	 public Node copyRandomList(Node head) {
	        HashMap<Node,Node> hs = new HashMap<>();
	        Node ptr = head;
	        while(ptr!=null){
	            Node copy = new Node(ptr.val);
	            copy.next = ptr.next;
	            ptr.random = ptr.random;
	            hs.put(ptr,copy);
	            ptr = ptr.next;
	        }
	        ptr = head;
	        while(ptr!=null){
	            Node cp = hs.get(ptr);
	            cp.next = hs.get(ptr.next);
	            cp.random = hs.get(ptr.random);
	            ptr = ptr.next;
	        }
	        Node copy=hs.get(head);
	        return copy;
	  }
	 public Node copyRandomListOptimizeSpace(Node head) {
	        if(head==null)
	    {
	        return null;
	    }
	    //step 1 : create a new node for each nod ein the original list and interweave them
	    Node current = head;
	    while(current!=null)
	    {
	        Node copy = new Node(current.val);
	        copy.next=current.next;
	        current.next=copy;
	        current=copy.next;
	    }
	   
	   //step2 : set the random pointers for new nodes.

	   current=head;
	   while(current!=null)
	   {
	    Node copy = current.next;
	    copy.random = (current.random!=null) ? current.random.next : null;
	    current = copy.next;
	   }

	   //step 3 : separate the original and copy list

	Node original = head;
	Node copyHead = head.next;
	Node copy = copyHead;
	while(original!=null)
	{
	    original.next = copy.next;
	    original=original.next;

	    if(original!=null)
	    {
	        copy.next = original.next;
	        copy = copy.next;
	    }
	}
	copy.next=null;

	return copyHead;


	    }

}
