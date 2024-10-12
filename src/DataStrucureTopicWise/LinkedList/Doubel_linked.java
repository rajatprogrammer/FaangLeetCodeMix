package DataStrucureTopicWise.LinkedList;

import java.math.BigInteger;

//https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/
public class Doubel_linked {
	
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
	
	 public ListNode doubleIt(ListNode head) {
	        //Create a String Builder to append the numerical values and use a while loop to iterate the node values
	        StringBuilder sb = new StringBuilder();
	        while (head!=null) {
	            sb.append(head.val);
	            head = head.next;
	        }
	        //Store the (2*num) value as BigInteger & convert it into a string
	        BigInteger num = new BigInteger(sb.toString()).multiply(BigInteger.valueOf(2));
	        String str = num.toString();
	        //Create the head ListNode
	        ListNode h = new ListNode(str.charAt(0) - '0');
	        ListNode curr = h;
	        //Start the loop and take the digits , create a ListNode with every value and add them as curr.next
	        for (int i = 1; i < str.length(); i++) {
	            int digit = str.charAt(i) - '0';
	            ListNode nd = new ListNode(digit);
	            //Update curr node to the next
	            curr.next = nd;
	            curr = curr.next;
	        }
	        //Return the head ListNode 
	        return h;
	    }

}
