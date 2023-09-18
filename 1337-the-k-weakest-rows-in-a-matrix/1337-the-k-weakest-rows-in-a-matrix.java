class Solution {
//     public int[] kWeakestRows(int[][] mat, int k) {
//        //  ArrayList<Integer> arr = new ArrayList<>();
//        // // HashMap<Integer , Integer> map = new HashMap<>();
//        //  int countArr[] = new int[1001];
//        //  for(int i=0;i<mat.length;i++){
//        //      int count =0;
//        //      for(int j=0;j<mat[0].length;j++){
//        //          if(mat[i][j]==1){
//        //              count++;
//        //          }
//        //      }
//        //      countArr[count] = i;
//        //      arr.add(count);
//        //  }
//        //  Collections.sort(arr);
//        //  int res[] = new int [k];
//        //  for(int i=0;i<k;i++){
//        //      res[i]= arr.get(i)%mat.length;
//        //  }
//        //  return res;
        
        
//     }
    
    
    
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] score = new int[rows];
        int j;
        for (int i = 0; i < rows; i++) {
            j = 0;
            for (; j < cols; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
            }
            /*
             * we can create a score to match the sort condition from description
             * score = soldiersCount * rows + currentRowIndex
             * so we can get soldiersCount by score / rows, and get rowIndex by score % rows
             */
            score[i] = j * rows + i;
        }

        Arrays.sort(score);
        for (int i = 0; i < score.length; i++) {
            // get rowIndex
            score[i] = score[i] % rows;
        }

        return Arrays.copyOfRange(score, 0, k);
    }
}


