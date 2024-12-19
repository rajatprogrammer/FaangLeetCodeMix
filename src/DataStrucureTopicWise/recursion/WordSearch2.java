package DataStrucureTopicWise.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-search-ii/description/
/*Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * */
public class WordSearch2 {
	
	 static class trieNode{
		String word;
		trieNode next[];
		public trieNode(String word){
			this.word = word;
			this.next = new trieNode[26];
		}
	}
	
	static int dirX[] = {0,0,1,-1};
	static int dirY[] = {1,-1,0,0};
	static List<String> res = new ArrayList<String>();
	public static void main(String[] args) {
		char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String words[] = {"oath","pea","eat","rain"};
		findWords(board,words);
		for(String rep : res) {
			System.out.println(rep);
		}
	}
	 public static List<String> findWords(char[][] board, String[] words) {
		 trieNode root=constructTrie(words);
		 for(int i=0;i<board.length;i++) {
			 for(int j=0;j<board[i].length;j++) {
				 backtrack(board,i,j,root);
			 }
		 }
		return res;
	 }
	 
	 public static boolean isSafe(int i, int j , trieNode root,char[][] board) {
		if(i<0 || i>=board.length || j<0 || j>=board[0].length) {
			return false;
		}
		int idx = board[i][j] - 'a';
		if(root.next[idx]==null) {
			return false;
		}
		if(board[i][j]=='#') {
			return false;
		}
		return true;
	 }
	 
	 public static void backtrack(char[][] board,int i,int j,trieNode root) {
		 if(isSafe(i,j,root,board)) {
			 if(root.word!=null) {
				 res.add(root.word);
				 root.word = null;
			 }else {
				 int idx = board[i][j] - 'a';
				 char temp = board[i][j];
				 for(int k=0;k<4;k++) 
					{
						 backtrack(board,i+dirX[k],j+dirY[k],root.next[idx]);
					}
				 board[i][j] = temp;
			 }
			 
		 }
	 }
	 
	 public static trieNode constructTrie(String arr[]) {
		 trieNode root=new trieNode(null);
		 for(int i=0;i<arr.length;i++) {
			 trieNode ptr=root;
			 for(int j=0;j<arr[i].length();j++) {
				 int in = arr[i].charAt(j) - 'a';
				 ptr.next[in] = new trieNode(null);
				 ptr = ptr.next[in];
			 }
			 ptr.word = arr[i];
		 }
		 return root;
	 }
	 

}
