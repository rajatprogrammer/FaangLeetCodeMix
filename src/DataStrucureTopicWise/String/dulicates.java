package DataStrucureTopicWise.String;
/*
 * 
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii
 * 
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 * */
public class dulicates {
	
	class Item {
	    char c;
	    int count;
	    
	    public Item(char c, int count){
	        this.c = c;
	        this.count = count;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String removeDuplicates(String s, int k) {
        Deque<Item> deque = new LinkedList();
        
        //Gready Apprach,
        //whenever we find the k consecutive same character just remove the dequeu (stack)
        
        for(char c : s.toCharArray()){
            if(deque.isEmpty()){
                deque.addLast(new Item(c, 1));
                continue;
            }
            
            //last stored item
            Item item = deque.peekLast();

            if(item.c != c){
                deque.addLast(new Item(c, 1));
                continue;
            }
            
            if(item.count == k - 1){
                deque.removeLast();
            }else{
                item.count++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            Item item = deque.removeFirst();      
            while(item.count --> 0){
                sb.append(item.c);
            }
        }
        
        //sb.reverse();
        
        return sb.toString();
        
    }

}
