class Solution {
    public int[] maxSlidingWindow(int[] arr, int K) {
        
		// removeLast, addLast
        // int N = arr.length;
		// Deque<Integer> dq = new ArrayDeque<>();

		// int[] ans = new int[N - K + 1];
		// int win_num = 0;

		// for (int i = 0; i < N; i++) {
		// 	if (dq.size() > 0 && dq.getFirst() <= i - K) {
		// 		dq.removeFirst();
		// 	} 

		// 	while (dq.size() > 0 && arr[dq.getLast()] < arr[i]) {
		// 		dq.removeLast();
		// 	}

		// 	dq.addLast(i);

		// 	if (i >= K - 1) {
		// 		ans[win_num] = arr[dq.getFirst()];
		// 		win_num++;
		// 	}
		// }

		// return ans;


        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0, j = 0;
        int[] ans = new int[n - K + 1];
        int max = Integer.MIN_VALUE;
        int ind=0;
        while (j < n) {
            while (!dq.isEmpty() && dq.peekLast() < arr[j]) {
                dq.pollLast();
            }
            dq.offerLast(arr[j]);

            if (j - i + 1 == K) {
                ans[ind++]=dq.peekFirst();

                if (arr[i] == dq.peekFirst()) {
                    dq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}