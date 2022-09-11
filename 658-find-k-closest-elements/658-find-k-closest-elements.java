class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int index = Arrays.binarySearch(arr, x);
        
        if(index<0)
            index = (index*-1)-1;
        
        int left = index-1;
        int right = index;
        System.out.println(left);
        while((left>=0 || right<arr.length) && k>0)
        {
            if(left<0)
            {
                right++;
                k--;
            }
            else if(right>=arr.length)
            {
                left--;
                k--;
            }
            else if(left==right)
            {
                left--;
                right++;
                k--;
            }
            else
            {
                if(Math.abs(arr[left]-x)<=Math.abs(arr[right]-x))
                {
                    left--;
                }
                else
                    right++;
                k--;
            }
        }
        System.out.println(left);
        System.out.println(right);
        for(int i=left+1;i<right;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}