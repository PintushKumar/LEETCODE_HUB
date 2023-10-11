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
        // Step 1: Count the frequency of each character in the string
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a priority queue to sort characters by frequency (in descending order)
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charFrequency.get(b) - charFrequency.get(a));

        // Step 3: Add all unique characters to the priority queue
        for (char c : s.toCharArray()) {
            if (!pq.contains(c)) {
                pq.offer(c);
            }
        }

        // Step 4: Build the sorted string by appending characters based on their frequency
        StringBuilder sortedString = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int frequency = charFrequency.get(c);
            for (int i = 0; i < frequency; i++) {
                sortedString.append(c);
            }
        }

        // Step 5: Return the sorted string
        return sortedString.toString();
    }
}
