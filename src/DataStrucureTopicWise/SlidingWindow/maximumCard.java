package DataStrucureTopicWise.SlidingWindow;
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class maximumCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int card[] = {1,2,3,4,5,6,1};
		int k=3;
		System.out.println(maxScore(card,k));
	}
	public static int maxScore(int[] cardPoints, int k) {
        int score = 0;

        for(int i = 0; i < k; ++i)
            score += cardPoints[i];

        int max = score;

        for(int i = cardPoints.length - 1; i >= cardPoints.length - k; --i) {
            score += cardPoints[i];
            score -= cardPoints[k - cardPoints.length + i];
            max = Math.max(score, max);
        }

        return max;
    }

}
