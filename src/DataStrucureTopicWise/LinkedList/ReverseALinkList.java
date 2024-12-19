package DataStrucureTopicWise.LinkedList;
//https://leetcode.com/problems/reverse-linked-list/description/
import DataStrucureTopicWise.LinkedList.MergeKsortedList.ListNode;

public class ReverseALinkList {
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
	public ListNode reverseList(ListNode head) {
	       ListNode ptr = head;
	        ListNode prev = null;
	        ListNode next = null;
	        while(ptr!=null){
	            next = ptr.next;
	            ptr.next = prev;
	            prev=ptr;
	            ptr=next;
	        }
	        head = prev;
	        return head;
	    }
	}

