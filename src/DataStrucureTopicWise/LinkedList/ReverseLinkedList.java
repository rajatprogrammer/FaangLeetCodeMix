package DataStrucureTopicWise.LinkedList;

//Reverse Linked List II
//https://leetcode.com/problems/reverse-linked-list-ii/description/
//https://leetcode.com/problems/delete-node-in-a-linked-list/description/
public class ReverseLinkedList {

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
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // Empty list
      if (head == null) {
          return null;
      }

      // Move the two pointers until they reach the proper starting point
      // in the list.
      ListNode cur = head, prev = null;
      while (m > 1) {
          prev = cur;
          cur = cur.next;
          m--;
          n--;
      }

      // The two pointers that will fix the final connections.
      ListNode con = prev, tail = cur;

      // Iteratively reverse the nodes until n becomes 0.
      ListNode third = null;
      while (n > 0) {
          third = cur.next;
          cur.next = prev;
          prev = cur;
          cur = third;
          n--;
      }

      // Adjust the final connections as explained in the algorithm
      if (con != null) {
          con.next = prev;
      } else {
          head = prev;
      }

      tail.next = cur;
      return head;
  }

}
