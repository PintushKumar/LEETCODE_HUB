class Solution {
    public int findPairs(int[] nums, int k) {
			if (k < 0) {
				return 0;
			}

			// Create a hash map to store the frequency of each element.
			Map<Integer, Integer> freqMap = new HashMap<>();
			for (int num : nums) {
				freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
			}

			// Initialize the count of pairs.
			int count = 0;

			// Iterate over the hash map.
			for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
				int num = entry.getKey();
				int freq = entry.getValue();
				// If k is 0, then we only count pairs where the element appears twice.
				if (k == 0) {
					if (freq > 1) {
						count++;
					}
				} else {
					// If k is positive, then we count pairs where the element appears with a difference of k.
					if (freqMap.containsKey(num + k)) {
						count++;
					}
				}
			}

			return count;
    }
}