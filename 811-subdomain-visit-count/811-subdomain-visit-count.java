class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i=0;i<cpdomains.length;i++)
        {
            String curr = cpdomains[i];
            String countAndDomains[] = curr.split(" ");
            int count = Integer.valueOf(countAndDomains[0]);
            String[] subdomains = countAndDomains[1].split("\\.");
            
            String currS = "";
            for(int j=subdomains.length-1;j>=0;j--)
            {
                currS = subdomains[j] + (j<subdomains.length-1?".":"") + currS;
                hm.put(currS,hm.getOrDefault(currS,0)+count);
            }
            
        }
        
        for(String s: hm.keySet())
        {
            result.add(hm.get(s)+" "+s);
        }
        return result;
    }
}