package DataStrucureTopicWise.LinkedList;

//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class Reverse_Nodes_in_k_Group {

	public class ListNode {
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
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private ListNode reverse(ListNode rootNode, int k) {
		if (rootNode == null)
			return null;
		ListNode current = rootNode;
		ListNode prev = null;
		ListNode next = null;

		int count = 0;
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null && nextAvailable(next, k)) {
			rootNode.next = reverse(next, k);
		} else {
			rootNode.next = next;
		}

		return prev;
	}

	public boolean nextAvailable(ListNode next, int k) {

		while (next != null && k > 0) {
			k--;
			next = next.next;
		}

		return k == 0 ? true : false;
	}

}
