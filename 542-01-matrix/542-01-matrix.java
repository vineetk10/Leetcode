class Pair{
    int r;
    int c;
    
    public Pair(int r, int c)
    {
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        
        for(int[] r : dist)
        {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        Deque<Pair> dq = new LinkedList<>();
        
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                  dist[i][j] = 0;
                  dq.add(new Pair(i,j));  
                }
            }
        }
        
        while(!dq.isEmpty())
        {
            Pair p = dq.remove();
            
            if(p.r>0 && dist[p.r-1][p.c]>dist[p.r][p.c]+1)
            {
                dist[p.r-1][p.c] = dist[p.r][p.c]+1;
                 dq.add(new Pair(p.r-1,p.c));
            }
            if(p.c>0 && dist[p.r][p.c-1]>dist[p.r][p.c]+1)
            {
                dist[p.r][p.c-1] = dist[p.r][p.c]+1;
                dq.add(new Pair(p.r,p.c-1));
            }
            if(p.r<dist.length-1 && dist[p.r+1][p.c]>dist[p.r][p.c]+1)
            {
                dist[p.r+1][p.c] = dist[p.r][p.c]+1;
                dq.add(new Pair(p.r+1,p.c));
            }
            if(p.c<dist[0].length-1 && dist[p.r][p.c+1]>dist[p.r][p.c]+1)
            {
                dist[p.r][p.c+1] = dist[p.r][p.c]+1;
                dq.add(new Pair(p.r,p.c+1));
            }
           
        }
        return dist;
    }
}