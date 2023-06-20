class Solution {
    public int[] maxSlidingWindow(int[] arr, int K) {
        
		// removeLast, addLast
        int N = arr.length;
		Deque<Integer> dq = new ArrayDeque<>();

		int[] ans = new int[N - K + 1];
		int win_num = 0;

		for (int i = 0; i < N; i++) {
			if (dq.size() > 0 && dq.getFirst() <= i - K) {
				dq.removeFirst();
			} 

			while (dq.size() > 0 && arr[dq.getLast()] < arr[i]) {
				dq.removeLast();
			}

			dq.addLast(i);

			if (i >= K - 1) {
				ans[win_num] = arr[dq.getFirst()];
				win_num++;
			}
		}

		return ans;
    }
}