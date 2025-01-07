class Solution {
    public void gameOfLife(int[][] board) {
        int i,j,k,n=board.length,m=board[0].length;
        int[][] dir={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        List<int[]> ones=new ArrayList<>();
        List<int[]> zeros=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                int live=0;
                for(int[] d:dir)
                {
                    int nr=i+d[0];
                    int nc=j+d[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && board[nr][nc]==1)
                        live++;
                    if(i==1 && j==0)
                        System.out.println(nr+" "+nc);
                }
                if(board[i][j]==1)
                {
                    if(live<2)
                        zeros.add(new int[]{i,j});
                    else if(live>3)
                        zeros.add(new int[]{i,j});
                }
                else
                {
                    if(live==3)
                        ones.add(new int[]{i,j});
                }
            }
        }
        for(int[] x:zeros)
            board[x[0]][x[1]]=0;
        for(int[] x:ones)
            board[x[0]][x[1]]=1;
    }
}