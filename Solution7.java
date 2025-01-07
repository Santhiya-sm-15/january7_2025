class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j,n=matrix.length,m=matrix[0].length;
        List<int[]> l=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                    l.add(new int[]{i,j});
            }
        }
        for(int[] x:l)
        {
            for(i=0;i<m;i++)
                matrix[x[0]][i]=0;
            for(i=0;i<n;i++)
                matrix[i][x[1]]=0;
        }
    }
}