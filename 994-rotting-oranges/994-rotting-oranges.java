class Node {
    int row;
    int col;
    
    public Node(int r, int c)
    {
        row = r;
        col = c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
       int ans = 0;
        
       Deque<Node> dq = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                    dq.add(new Node(i,j));
            }
        }
        
        while(dq.size()>0)
        {
            int s = dq.size();
                boolean visited = false;
            
            while(s>0)
            {
                Node n = dq.removeFirst();
                if(n.row>0 && grid[n.row-1][n.col]==1)
                {
                    dq.add(new Node(n.row-1, n.col));
                    grid[n.row-1][n.col]=2;
                    visited = true;
                }
                if(n.row<grid.length-1 && grid[n.row+1][n.col]==1)
                {
                    dq.add(new Node(n.row+1, n.col));
                    grid[n.row+1][n.col]=2;
                    visited = true;
                }
                if(n.col>0 && grid[n.row][n.col-1]==1)
                {
                    dq.add(new Node(n.row, n.col-1));
                    grid[n.row][n.col-1]=2;
                    visited = true;
                }
                if(n.col<grid[0].length-1 && grid[n.row][n.col+1]==1) 
                {
                    dq.add(new Node(n.row, n.col+1));
                    grid[n.row][n.col+1]=2;
                    visited = true;
                }
                s--;
            }
            if(visited)
                ans++;
            else 
                break;
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return ans;
        
    }
}