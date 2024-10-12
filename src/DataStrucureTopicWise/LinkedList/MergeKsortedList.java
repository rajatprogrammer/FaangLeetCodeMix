package DataStrucureTopicWise.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKsortedList {
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
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length<=0){
            return null;
        }else {
        	 ListNode head = new ListNode(0);
             ListNode point = head;
             PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
            		 new Comparator<ListNode>() {
						@Override
						public int compare(ListNode o1, ListNode o2) {
							if(o1.val>o2.val) {
								return 1;
							}else if(o1.val==o2.val){
								return 0;
							}else {
								return -1;
							}
						}	 
					}
             );
             for (ListNode node : lists) {
                 if (node != null) {
                	 pq.add(node);
                 }
             }
             while(pq.size()> 0) {
            	 point.next = pq.poll();
            	 point = point.next;
            	 if (point.next != null) {
            		 pq.add(point.next);
                 }
             }
             return head.next;
        }
	}

}
