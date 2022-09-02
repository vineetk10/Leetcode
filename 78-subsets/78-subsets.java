class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
       List<Integer> currArr = new ArrayList<>();
        res.add(currArr);
        for(int i=0;i<nums.length;i++)
        {
            Subsets(nums, res, i, currArr);
            
        }
        return res;
    }
    
    public static void Subsets(int[] nums, List<List<Integer>> res, int index, List<Integer> currArr)
    {
        if(index == nums.length)
        {
            res.add(new ArrayList<>(currArr));
            return;
        }
        
        for(int i = index;i<nums.length;i++)
        {
            currArr.add(nums[index]);
            Subsets(nums, res, i+1, currArr);
            currArr.remove(currArr.size()-1);
        }
    }
}