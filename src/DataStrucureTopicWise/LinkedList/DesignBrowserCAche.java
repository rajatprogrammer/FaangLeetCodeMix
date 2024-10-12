package DataStrucureTopicWise.LinkedList;
//https://leetcode.com/problems/design-browser-history/

public class DesignBrowserCAche {
	
		class node{
			String url;
			node prev;
			node next;
			public node(String data) {
				this.url = data;
				this.prev = null;
				this.next = null;
			}
		}
		node cache;
		node ptr;
		public DesignBrowserCAche(String data) {
			cache = new node(data);
			ptr=cache;
		}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	 public void visit(String url) {
	        ptr.next = new node(url);
	        ptr.next.prev = ptr;
	        ptr = ptr.next;
	 }
	    
	 public String back(int steps) {
		 	while(ptr!=null  && steps>0) {
		 		if(ptr.prev==null) {
		 			break;
		 		}else {
		 			ptr = ptr.prev;
			 		steps --;
		 		}
		 	}
		 	return ptr.url;
	 }
	    
	    public String forward(int steps) {
	    	while(ptr!=null  && steps>0) {
		 		if(ptr.next==null) {
		 			break;
		 		}else {
		 			ptr = ptr.next;
			 		steps --;
		 		}
		 	}
		 	return ptr.url;
	   }

}
