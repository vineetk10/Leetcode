import java.util.Collections;
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        // for(int i=citations.length-1;i>=0;i--)
        // {
        //     if(citations[i]>=citations.length - i)
        //         res=citations.length - i;
        // }
        int low = 0;
        int high = citations.length-1;
        
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(citations[mid]>=citations.length - mid){
                res=citations.length - mid;
                high = mid-1;
                
            }
            else
            {
                low = mid+1;
            }
        }
        return res;
    }
}