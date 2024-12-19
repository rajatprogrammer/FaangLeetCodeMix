package DataStrucureTopicWise.LinkedList;

import DataStrucureTopicWise.LinkedList.Doubel_linked.ListNode;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class LinklistFlatten {
	
	ListNode prev = null;
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	    
	    public Node flatten(Node head) {
	        if (head == null) return head;
	        
	        flatten(head.next);
	        flatten(head.child);
	        
	        if (prev != null){
	            head.next = prev;
	            prev.prev = head;
	            head.child = null;
	        }
	        prev = head;
	        return head;
	    }

}
