package InterviewFaang.Trie;

import java.util.LinkedList;
import java.util.List;
//https://leetcode.com/problems/stream-of-characters/
class Trie {
	
	Trie[] children;
	boolean isEnd;
	char ch;
	
	public Trie (char ch) {
		children = new Trie[26];
		isEnd = false;
		this.ch =ch;
	}
}
//https://leetcode.com/problems/stream-of-characters/
public class stream_character {
	Trie root=new Trie('0');
	List<Character> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String wo[] = {"cd"};
		stream_character ob1= new stream_character(wo);
		System.out.print(ob1.query('d'));
	}
	//constructor for intialise the word
	 public stream_character(String[] words) {
		 list = new LinkedList<Character>();
	    	 for(int i=0;i<words.length;i++) {
	    		 insert(words[0]);
	    	 }  	  
	 }
	 
	 public void insert(String word) {
		 Trie node = root;
		 for(int i=word.length()-1;i>=0;i--) {
			 char ch = word.charAt(i);
			 if(node.children[ch-'a']==null) {
				 node.children[ch-'a'] = new Trie(ch);
			 }else {
				 node=node.children[ch-'a'];
			 }
		 }
		 node.isEnd=true;
	 }
	 	public boolean query(char letter) {
	 		list.add(letter);
	 		return searchWord();
	    }
	 	public boolean searchWord () {
			
			Trie node = root;
			for (int i = list.size () - 1; i >= 0; i--) {
				char letter = list.get (i);
				if (node.children[letter - 'a'] == null) {
					return false;
				}
				node = node.children[letter - 'a'];
				if (node.isEnd) {
					return true;
				}
			}
			
			return false;
		}
}
