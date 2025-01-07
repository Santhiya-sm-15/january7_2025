class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i,n=matrix.length,m=matrix[0].length;
        List<Integer> res=new ArrayList<>();
        int rowS=0,colS=0,rowE=n-1,colE=m-1;
        while(rowS<=rowE && colS<=colE)
        {
            for(i=colS;i<=colE;i++)
                res.add(matrix[rowS][i]);
            rowS++;
            for(i=rowS;i<=rowE;i++)
                res.add(matrix[i][colE]);
            colE--;
            if(rowS<=rowE)
            {
                for(i=colE;i>=colS;i--)
                    res.add(matrix[rowE][i]);
                rowE--;
            }
            if(colS<=colE)
            {
                for(i=rowE;i>=rowS;i--)
                    res.add(matrix[i][colS]);
                colS++;
            }
        }
        return res;
    }
}