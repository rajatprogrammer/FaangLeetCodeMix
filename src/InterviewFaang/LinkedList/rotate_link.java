package LinkedList;
//https://www.geeksforgeeks.org/rotate-a-linked-list/
public class rotate_link {
	static class Node{
	    int data;
	    Node next;
	    Node(int d){
	        data=d;
	        next=null;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		rotate_link ob1 =new rotate_link();
		int k=4;
		root=ob1.rotate(root,k);
		while(root!=null) {
			System.out.print(root.data);
			root=root.next;
		}
	}
	
	public Node rotate(Node head, int k) {
	       if (k == 0) return head;
	        
	        Node walk = head;
	        Node prev = null;
	        
	        while( k-->0 && walk!=null )
	        // this loop is run k number of times
	        // walk pointer moves k nodes ahead and reaches new head node
	        {
	            prev = walk;
	            walk = walk.next;
	        }
	        if(walk==null) return head; // considering edge case, i.e. if k==n
	        
	        Node newHead = walk;
	        // since 'prev' points to the node placed before newHead
	        // it is new tail, hence prev->next should be NULL
	        prev.next = null;
	        
	        while( walk.next != null )
	            // walking till the last node
	            walk = walk.next;
	        
	        // connecting last node to old head
	        walk.next = head;
	        return newHead;

	    }

}
