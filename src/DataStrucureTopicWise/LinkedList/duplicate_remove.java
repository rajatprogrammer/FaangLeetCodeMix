package DataStrucureTopicWise.LinkedList;

import DataStrucureTopicWise.LinkedList.LinklistFlatten.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
public class duplicate_remove {

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
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0, head);
		ListNode prev = dummy;

		while(head != null) {
			if(head.next != null && head.val == head.next.val){
				//skip the nodes whose values are equal to head.
				while(head.next != null && head.val == head.next.val){
					head = head.next;
				}
				prev.next = head.next;
			}
			else{
				prev = prev.next;
			}
			head = head.next;
		}
		return dummy.next;
	}

}
