class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean flag = false;
        int rows = board.length;
        int cols = board[0].length;
        
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols-2;c++)
            {
                int val = Math.abs(board[r][c]);
                
                if(val!=0 && Math.abs(val)==Math.abs(board[r][c+1]) && Math.abs(val)==Math.abs(board[r][c+2]))
                {
                    flag = true;
                    board[r][c] = board[r][c+1] = board[r][c+2] = -val;
                }
            }
        }
        
        for(int r=0;r<rows-2;r++)
        {
            for(int c=0;c<cols;c++)
            {
                int val = Math.abs(board[r][c]);
                
                if(val!=0 && Math.abs(val)==Math.abs(board[r+1][c]) && Math.abs(val)==Math.abs(board[r+2][c]))
                {
                    flag = true;
                    board[r][c] = board[r+1][c] = board[r+2][c] = -val;
                }
            }
        }
        
        
        
        for(int c=0;c<cols;c++)
        {
            int rowCounter = rows-1;
            for(int r = rows-1;r>=0;r--)
            {
                if(board[r][c]>0)
                {
                    board[rowCounter--][c] = board[r][c];
                }
            }
            
            while(rowCounter>=0)
                board[rowCounter--][c] = 0;
        }    
        
        return flag ? candyCrush(board) : board;
    }
}