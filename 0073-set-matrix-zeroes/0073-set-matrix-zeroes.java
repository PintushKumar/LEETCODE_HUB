class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length; // Get the number of rows in the matrix
        int m = matrix[0].length; // Get the number of columns in the matrix
        int row[] = new int[n]; // Create an array to keep track of rows containing zeroes
        int col[] = new int[m]; // Create an array to keep track of columns containing zeroes

        // First pass: Scan the original matrix to identify rows and columns with zeroes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i]++; // Increment the count of zeroes in the current row
                    col[j]++; // Increment the count of zeroes in the current column
                }
            }
        }

        // Second pass: Update the original matrix based on the information in row[] and col[]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] >= 1 || col[j] >= 1) {
                    matrix[i][j] = 0; // If the current row or column contains a zero, set the element to zero
                }
            }
        }
    }
}


// ************** Efficient Solution ***********************


// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         boolean firstRow = false;
//         boolean firstCol = false;

//         // Check the first row and first column for zeros
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (matrix[i][j] == 0) {
//                     if (i == 0) firstRow = true;
//                     if (j == 0) firstCol = true;
//                     matrix[i][0] = 0; // Store the information in the first row and column
//                     matrix[0][j] = 0;
//                 }
//             }
//         }

//         // Iterate through the rest of the matrix
//         for (int i = 1; i < n; i++) {
//             for (int j = 1; j < m; j++) {
//                 if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                     matrix[i][j] = 0; // Set to 0 based on the information in the first row and column
//                 }
//             }
//         }

//         // Handle the first row if it should be set to 0
//         if (firstRow) {
//             for (int j = 0; j < m; j++) {
//                 matrix[0][j] = 0;
//             }
//         }

//         // Handle the first column if it should be set to 0
//         if (firstCol) {
//             for (int i = 0; i < n; i++) {
//                 matrix[i][0] = 0;
//             }
//         }
//     }
// }
