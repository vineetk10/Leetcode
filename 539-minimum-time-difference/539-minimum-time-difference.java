class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size()>24*60)
            return 0;
        HashSet<Integer> minutes = new HashSet<>();
        int resArr[] = new int[timePoints.size()];
        
        for(int i=0;i<timePoints.size();i++)
        {
            String time = timePoints.get(i);
            resArr[i] = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3,5));
            if(minutes.contains(resArr[i]))
                return 0;
            minutes.add(resArr[i]);
        }
        
        Arrays.sort(resArr);
        
        int res = Integer.MAX_VALUE;
        
        for(int i=1;i<resArr.length;i++)
        {
            res = Math.min(res, resArr[i]-resArr[i-1]);
        }
        
        res = Math.min(res, resArr[0]+ (24*60 - resArr[resArr.length-1]));
        return res;
    }
}
