class Solution {
    	int[] nextSmallerElementOnLeftIndexwise (int[] arr, int n) {
		// Stack: people looking for nsel
		Stack<Integer> st = new Stack<>();

		int[] nseli = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] > arr[i]) {
				nseli[st.pop()] = i;
			}
			st.push(i);
		}

		while (st.size() > 0) {
            // suppose we stand at zero position then smaller element indexwise is -1
			nseli[st.pop()] = -1;
		}

		return nseli;
	}

	int[] nextSmallerElementOnRightIndexwise (int[] arr, int n) {
		// Stack: people looking for nser
		Stack<Integer> st = new Stack<>();

		int[] nseri = new int[n];

		for (int i = 0; i < n; i++) {
			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				nseri[st.pop()] = i;
			}
			st.push(i);
		}

		while (st.size() > 0) {
            // suppose we stand at last position then smaller element indexwise is n ( that means out of range)
			nseri[st.pop()] = n;
		}

		return nseri;
	}

	long mod = 1000000007;
    public int sumSubarrayMins(int[] a) {
        int n = a.length;
        int[] nseli = nextSmallerElementOnLeftIndexwise(a, n);
		int[] nseri = nextSmallerElementOnRightIndexwise(a, n);

		long ans = 0;
		for (int i = 0; i < n; i++) {
			long numberOfSubarray = (i - nseli[i]) * (nseri[i] - i);
			long sum = ((numberOfSubarray % mod) * (a[i] % mod)) % mod;
			ans = (ans + sum) % mod ;
		}

		return (int)ans;
        
    }
}