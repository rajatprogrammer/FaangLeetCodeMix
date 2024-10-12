package String;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/longest-happy-string/
//amazon
public class happy_string {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a = 1, b = 1, c = 7;
		System.out.print(longestDiverseString(a,b,c)); 
	}

	public static String longestDiverseString(int a, int b, int c) {
        // elem: [0] -> char - 'a', [1] -> count[char]
        Queue<int[]> queue = new PriorityQueue<int[]>((x, y) -> y[1] - x[1]); 
        queue.offer(new int[] {0, a});
        queue.offer(new int[] {1, b});
        queue.offer(new int[] {2, c});
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] curr = queue.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) - 'a' == curr[0] && 
                sb.charAt(sb.length() - 2) - 'a' == curr[0]) {
                int[] tmp = queue.poll();
                queue.add(curr);
                curr = tmp;
            }
            if (curr[1] == 0) break;
            sb.append((char)('a' + curr[0]));
            curr[1]--;
            queue.add(curr);
        }
        return sb.toString();
    }
}
