class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Initialize a list to store the rows of Pascal's triangle.
        List<List<Integer>> res = new ArrayList<>();
        
        // Iterate through the given number of rows.
        for (int i = 0; i < numRows; i++) {
            // Initialize a list to represent the current row.
            List<Integer> row = new ArrayList<>();
            
            // Iterate through the elements of the current row.
            for (int j = 0; j <= i; j++) {
                // Check if the element is at the beginning or end of the row.
                if (j == 0 || j == i) {
                    row.add(1); // Set the element to 1.
                } else {
                    // Calculate the middle elements by summing the two elements directly above.
                    int num = res.get(i - 1).get(j) + res.get(i - 1).get(j - 1);
                    row.add(num); // Add the calculated element to the current row.
                }
            }
            
            // Add the current row to the result list.
            res.add(row);
        }
        
        // Return the resulting Pascal's triangle.
        return res;
    }
}
