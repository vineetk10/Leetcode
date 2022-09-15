class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length+1;
        int m = nums2.length + 1;
        int[][]dp = new int[n][m];
        int max = 0;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
//     public int count = Integer.MIN_VALUE;
//     public int findLength(int[] nums1, int[] nums2) {
//          int[][]dp = new int[nums1.length +1][nums2.length + 1];
//         for(int[] arr: dp){ 
//             for(int i =0;i <arr.length ;++i){
//                 arr[i] = -1;
//             }
//         }
//         FindLength(nums1, nums2, 0 , 0, dp);
//         return count;
//     }
    
//     public int FindLength(int[] nums1, int[] nums2, int i, int j, int[][]dp)
//     {
//         if(i>=nums1.length || j>=nums2.length)
//             return 0;
        
//         if(dp[i][j]!=-1)
//             return dp[i][j];
        
//         int c1 = 0;
        
//         if(nums1[i]==nums2[j])
//             c1 = 1+FindLength(nums1, nums2, i+1 , j+1, dp);
        
        
//         count = Math.max(count, c1);
//         FindLength(nums1, nums2, i+1 , j, dp);
//         FindLength(nums1, nums2, i , j+1, dp);
        
//         dp[i][j] = c1;
//         return c1; 
//     }
       
}