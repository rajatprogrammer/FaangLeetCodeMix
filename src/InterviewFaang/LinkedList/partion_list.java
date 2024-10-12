package LinkedList;

//https://leetcode.com/problems/partition-list/
public class partion_list {
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

		public ListNode partition(ListNode head, int x) {
			ListNode before = new ListNode(-1), after = new ListNode(-1);
			ListNode ptrBefore = before, ptrAfter = after, curr = head;
			while (curr != null) {
				ListNode next = curr.next;
				curr.next = null;
				if (curr.val < x) {
					ptrBefore.next = curr;
					ptrBefore = ptrBefore.next;
				} else {
					ptrAfter.next = curr;
					ptrAfter = ptrAfter.next;
				}
				curr = next;
			}

			ptrBefore.next = after.next;
			return before.next;
		}
	}

}
