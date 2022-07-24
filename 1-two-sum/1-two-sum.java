class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) == true){
                answer[0] = map.get(diff);
                answer[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return answer;

    }
}