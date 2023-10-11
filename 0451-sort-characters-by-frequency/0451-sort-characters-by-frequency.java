// class Solution {
//     public String frequencySort(String s) {
//         // Step 1: Create a HashMap to store the frequency of each character
//         Map<Character, Integer> frequencyMap = new HashMap<>();
//         int maxFrequency = Integer.MIN_VALUE;

//         // Calculate the frequency of each character
//         for (char ch : s.toCharArray()) {
//             frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
//             maxFrequency = Math.max(maxFrequency, frequencyMap.get(ch));
//         }

//         // Step 2: Create a bucket sort array to group characters by frequency
//         List<Character>[] bucketSortArray = new List[maxFrequency + 1];

//         // Place characters into their respective frequency buckets
//         for (Character ch : frequencyMap.keySet()) {
//             int freq = frequencyMap.get(ch);
//             if (bucketSortArray[freq] == null) {
//                 bucketSortArray[freq] = new ArrayList<>();
//             }
//             bucketSortArray[freq].add(ch);
//         }

//         // Step 3: Build the sorted string by appending characters from the buckets
//         StringBuilder sortedString = new StringBuilder();

//         // Traverse the buckets from highest to lowest frequency
//         for (int i = bucketSortArray.length - 1; i >= 0; i--) {
//             List<Character> list = bucketSortArray[i];
//             if (list != null) {
//                 // Append each character the appropriate number of times to the result string
//                 for (Character ch : list) {
//                     for (int j = 0; j < i; j++) {
//                         sortedString.append(ch);
//                     }
//                 }
//             }
//         }

//         // Step 4: Return the sorted string
//         return sortedString.toString();
//     }
// }





class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

		pq.addAll(map.entrySet());
        
		StringBuilder ans = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> head = pq.poll();
			int freq = head.getValue();
			while (freq-- > 0) {
				ans.append(head.getKey());
			}
		}
		return ans.toString();
    }
}