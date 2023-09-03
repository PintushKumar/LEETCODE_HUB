class Solution {
    static class Pair{
        int r;
        int c;
        Pair(int r , int c){
            this.r = r;
            this.c = c;
        }
    }
    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new ArrayDeque<>();
        int fresh =0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        int time  =0;

        while(q.size()>0){
            int size =q.size();
            int temp =0;
            while(size-->0){
                Pair p = q.remove();
                if(p.r-1>=0 && grid[p.r-1][p.c]==1){
                    grid[p.r-1][p.c]=2;
                    q.add(new Pair(p.r-1 , p.c));
                    temp++;
                }
                if(p.r+1<n && grid[p.r+1][p.c]==1){
                    grid[p.r+1][p.c]=2;
                    q.add(new Pair(p.r+1 , p.c));
                    temp++;
                }
                if(p.c-1>=0 && grid[p.r][p.c-1]==1){
                    grid[p.r][p.c-1]=2;
                    q.add(new Pair(p.r , p.c-1));
                    temp++;
                }
                if(p.c+1<m && grid[p.r][p.c+1]==1){
                    grid[p.r][p.c+1]=2;
                    q.add(new Pair(p.r , p.c+1));
                    temp++;
                }
            }
            if(temp !=0){
                time++;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    time =0;
                    break;
                }
            }
        }
        return (time == 0) ? -1 : time;

    }
}