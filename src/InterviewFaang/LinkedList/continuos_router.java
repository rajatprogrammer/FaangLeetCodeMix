/**
 * Q.There is a network router which recive a continuos stream of packet at each second

let say at t0= 4
at t1= 87
at t2=32

after certain interval every time a querry is fired on this stream let say k=40 at t3 so the program have to return count of smallest value so output is 2 =[4,32] .

at t4=17
at t5=20
at t6=100
at t7== a query is fired where k=50 output= 4 as [32,4,17,20] these timestamp value is smallest then querry.

Point To Note
1.Production Read code
2.Handle all edge cases

Your solution querry computing time is equal to O(log(n)) and your insertion time is also O(log n). and don't used any sorting on whole data
 */
package InterviewFaang.LinkedList;

public class continuos_router {
	static class Node{
		int val;
		Node prev;
		Node next;
		int count;
		public Node(int val) {
			this.val=val;
			this.prev=null;
			this.next=null;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(4);
		continuos_router ob1= new continuos_router();
		ob1.insert(87, head);
		ob1.insert(32, head);
		ob1.insert(2, head);
		ob1.insert(12, head);
	}
	public void insert(int data,Node root) {
		Node mid = findMidPoint(root);
		insertHelper(mid,data,root);
	}
	
	public Node findMidPoint(Node head) {
		Node slow = head;
		Node Fast = head;
		while(Fast!=null && Fast.next!=null) {
			slow=slow.next;
			Fast=Fast.next.next;
		}
		return slow;
	}
	public Node findPrevMidPoint(Node Prev,Node head) {
		Node slow = Prev;
		Node Fast = Prev;
		while(Fast!=null && Fast.prev!=null) {
			slow=slow.prev;
			Fast=Fast.prev.prev;
		}
		return slow;
	}
	
	
	public void insertHelper(Node mid,int data,Node head) {
		if(mid.val<=data) {
			Node temp = mid.next;
			Node newNode = new Node(data);
			mid.next=newNode;
			newNode.prev=mid;
			newNode.next=temp;
			if(temp!=null) {
				temp.prev=newNode;
			}
			return;
		}else if(mid.prev==null) {
			Node temp = mid.next;
			Node newNode = new Node(mid.val);
			mid.val=data;
			mid.next=newNode;
			newNode.prev=mid;
			newNode.next=temp;
			if(temp!=null) {
				temp.prev=newNode;
			}
		}
		else {
			mid=findPrevMidPoint(mid, head);
			insertHelper(mid,data,head);
		}
		
	}

}
