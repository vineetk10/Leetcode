class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color)     {
        if(image[sr][sc]==color)
            return image;
        FloodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    public static void FloodFill(int[][] image, int sr, int sc, int color, int srcColor) 
    {
        image[sr][sc] = color;
        boolean visited = false;
        if(sr>0 && image[sr-1][sc]==srcColor)
                {
                    FloodFill(image,sr-1,sc, color, srcColor);
                    visited = true;
                }
                if(sr<image.length-1 && image[sr+1][sc]==srcColor)
                {
                    FloodFill(image,sr+1,sc, color, srcColor);
                    visited = true;
                }
                if(sc>0 && image[sr][sc-1]==srcColor)
                {
                    FloodFill(image,sr,sc-1, color, srcColor);
                    visited = true;
                }
                if(sc<image[0].length-1 && image[sr][sc+1]==srcColor) 
                {
                    FloodFill(image,sr,sc+1, color, srcColor);
                    visited = true;
                }
        if(!visited)
            return;
    }
}