package LinkedList;
//https://leetcode.com/problems/palindrome-linked-list/
public class palindrome_link {
	 static ListNode node;
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
		public boolean isPalindrome(ListNode head) {
	        node = head;
	        return palindrome(head);   
	    }
	    
	    public boolean palindrome(ListNode head){
	        if(head == null) return true;
	        
	        boolean pal = palindrome(head.next);
	        
	        if(pal == false) return false; //if at one point false , then keep returning false
	        
	        if(node.val == head.val){ //If the very end call stack is same as first
	            node = node.next;     // then current itteration is a palindrome
	            return true;
	        } 
	        return false;
	    }

	}
}
