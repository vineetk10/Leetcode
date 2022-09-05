class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int mat[][] = new int[n][n];
        NQueens(n, mat, 0, result);
        return result;
    }
    
    public static void NQueens(int n, int mat[][], int row, List<List<String>> result)
    {
        if(row==n)
        {
            List<String> curr = new ArrayList<>();
            
            for(int i=0;i<n;i++)
            {
                StringBuffer sb = new StringBuffer();
                for(int j=0;j<n;j++)
                {
                    if(mat[i][j]==0){
                        sb.append(".");
                    }
                    else
                        sb.append("Q");
                }
                curr.add(sb.toString());
            }
            result.add(new ArrayList<>(curr));
        }
        
        for(int col=0;col<n;col++)
        {
            if(IsValid(mat, row, col))
            {
                mat[row][col]=1;
                NQueens(n, mat, row+1, result);
                mat[row][col]=0;
            }
        }
    }
    
    public static boolean IsValid(int mat[][], int row, int col)
    {
        for(int i=0;i<mat.length;i++)
        {
            if(i!=row && mat[i][col]==1)
                return false;
        }
        int i = row;
        int j= col;
        while(i>0 && j>0)
        {
            if(mat[i-1][j-1]==1)
                return false;
            i--;
            j--;
        }
        
         i = row;
         j= col;
        while(i<mat.length-1 && j<mat.length-1)
        {
            if(mat[i+1][j+1]==1)
                return false;
            i++;
            j++;
        }
        
         i = row;
         j= col;
        while(i>0 && j<mat.length-1)
        {
            if(mat[i-1][j+1]==1)
                return false;
            i--;
            j++;
        }
        
         i = row;
         j= col;
        while(i<mat.length-1 && j>0)
        {
            if(mat[i+1][j-1]==1)
                return false;
            i++;
            j--;
        }
        
        return true;
    }
}

