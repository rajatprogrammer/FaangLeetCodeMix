package Subarray;
//amazon
//https://www.geeksforgeeks.org/length-of-longest-subarray-with-same-elements-in-atmost-k-increments/
public class longest_subarray_k_incr {
	// we can change segment tree according to even odd concept
	static int segment_tree[] = new int[4 * 1000000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 0, 4, 6, 7 }, K = 6;
		int N = arr.length;

		System.out.println(longestSubArray(arr, N, K));
	}

	static int build(int A[], int start, int end, int node) {
		if (start == end)

			// update the value in segment
			// tree from given array
			segment_tree[node] = A[start];

		else {

			// find the middle index
			int mid = (start + end) / 2;

			// If there are more than one
			// elements, then recur for left
			// and right subtrees and
			// store the max of values in this node
			segment_tree[node] = Math.max(build(A, start, mid, 2 * node + 1), build(A, mid + 1, end, 2 * node + 2));
		}
		return segment_tree[node];
	}

	static int query(int start, int end, int l, int r, int node) {
		// If the range is out of bounds,
		// return -1
		if (start > r || end < l)
			return -1;
		if (start >= l && end <= r)
			return segment_tree[node];
		int mid = (start + end) / 2;

		return Math.max(query(start, mid, l, r, 2 * node + 1), query(mid + 1, end, l, r, 2 * node + 2));
	}

	// Function that returns length of longest
	// subarray with same elements in atmost
	// K increments.
	static int longestSubArray(int A[], int N, int K) {

		// Initialize the result variable
		// Even though the K is 0,
		// the required longest subarray,
		// in that case, will also be of length 1
		int res = 1;

		// Initialize the prefix sum array
		int preSum[] = new int[N + 1];

		// Build the prefix sum array
		preSum[0] = A[0];
		for (int i = 0; i < N; i++)
			preSum[i + 1] = preSum[i] + A[i];

		// Build the segment tree
		// for range max query
		build(A, 0, N - 1, 0);

		// Loop through the array
		// with a starting point as i
		// for the required subarray till
		// the longest subarray is found
		for (int i = 0; i < N; i++) {

			int start = i, end = N - 1, mid, max_index = i;

			// Performing the binary search
			// to find the endpoint
			// for the selected range
			while (start <= end) {

				// Find the mid for binary search
				mid = (start + end) / 2;

				// Find the max element
				// in the range [i, mid]
				// using Segment Tree
				int max_element = query(0, N - 1, i, mid, 0);

				// Total sum of subarray after increments
				int expected_sum = (mid - i + 1) * max_element;

				// Actual sum of elements
				// before increments
				int actual_sum = preSum[mid + 1] - preSum[i];

				// Check if such increment is possible
				// If true, then current i
				// is the actual starting point
				// of the required longest subarray
				if (expected_sum - actual_sum <= K) {

					// Now for finding the endpoint
					// for this range
					// Perform the Binary search again
					// with the updated start
					start = mid + 1;

					// Store max end point for the range
					// to give longest subarray
					max_index = Math.max(max_index, mid);
				}

				// If false, it means that
				// the selected range is invalid
				else {

					// Perform the Binary Search again
					// with the updated end
					end = mid - 1;
				}
			}

			// Store the length of longest subarray
			res = Math.max(res, max_index - i + 1);
		}

		// Return result
		return res;
	}

}
