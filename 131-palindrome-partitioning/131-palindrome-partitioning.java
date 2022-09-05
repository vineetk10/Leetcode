class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        // for(int i=0;i<s.length();i++)
        // {
            Partition(s, res , curr, 0);
        // }
        return res;
    }
    
    public static void Partition(String s, List<List<String>> res, List<String> curr, int index)
    {
        if(index==s.length())
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=index+1;i<=s.length();i++)
        {
            if(isPali(s, index, i-1))
            {
                System.out.println("Hi"+ s.substring(index, i));
                curr.add(s.substring(index, i));
                Partition(s, res, curr, i);
                curr.remove(curr.size()-1);
            }
            
        }
    }
    
    public static boolean isPali(String s, int start, int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}