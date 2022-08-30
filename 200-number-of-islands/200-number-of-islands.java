class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    DFS(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void DFS(char[][] grid, int r, int c)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0')
            return;
        
        grid[r][c] = '0';
        
        DFS(grid, r-1,c);
        DFS(grid, r,c-1);
        DFS(grid, r+1,c);
        DFS(grid, r,c+1);
    }
}