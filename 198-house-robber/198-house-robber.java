class Solution {
    public int rob(int[] nums) {
        int currSum = 0;
        
//         int dp[] = new int[nums.length+1];
        
//         dp[0] = 0;
//         dp[1] = nums[0];
        
//         for(int i = 2;i<=nums.length;i++)
//         {
//             dp[i] = Math.max(dp[i-1],nums[i-1] + dp[i-2]);
//         }
        
//         return dp[nums.length];
        int skip = 0;
        int choose = 0;
        
        for(int num: nums)
        {
            int temp = choose;
            choose=skip+num;
            skip=Math.max(skip, temp);
        }
        
        return Math.max(skip,choose);
        //return Rob(currSum, 0, nums);
    }
    
    /*
    public static int Rob(int currSum, int i, int[] nums)
    {
        if(i>=nums.length)
        {
            return currSum;
        }
        
        return Math.max(Rob(currSum+nums[i],i+2,nums), Rob(currSum, i+1, nums));
    }
    */
}