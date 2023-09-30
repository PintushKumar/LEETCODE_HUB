class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a , b)->{
            return a[0]-b[0];
        });
        int count =0;
        int prevEnd = Integer.MIN_VALUE;
        for(int interval[]: intervals){
            int currStart = interval[0];
            int currEnd = interval[1];
            if(prevEnd <= currStart){
                count++;
                prevEnd = currEnd;
            }else{
                prevEnd = Math.min(prevEnd , currEnd);
            }
        }
        return intervals.length - count;
    }
}