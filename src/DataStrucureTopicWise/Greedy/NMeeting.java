package DataStrucureTopicWise.Greedy;

import java.util.Arrays;
import java.util.Comparator;

//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
public class NMeeting {
	
	static class meet{
		int start;
		int end;
		int pos;
		public meet(int start,int end,int i) {
			this.start = start;
			this.end = end;
			this.pos = i;
		}
	}

	public static void main(String[] args) {
		int start[] = {0,3,1,5,5,8};
		int end [] = {5,4,2,9,7,9};
		
		
		System.out.println(returnMeetingCount(start,end));

	}
	
	public static int returnMeetingCount(int start[], int end[]) {
		meet ob[] = new meet[start.length];
		for(int i=0;i<start.length;i++) {
			ob[i] = new meet(start[i], end[i], i);
		}
		Arrays.sort(ob, new Comparator<meet>() {
			@Override
			public int compare(meet o1, meet o2) {
				return o1.end - o2.end;
			}
			
		});
		
		int count =1;
		int end1 = ob[0].end;
		
		for(int i=1;i<ob.length;i++) {
			if(end1<ob[i].start) {
				count++;
				end1 = ob[i].end;
			}else {
				continue;
			}
		}
		return count;
	}

}
