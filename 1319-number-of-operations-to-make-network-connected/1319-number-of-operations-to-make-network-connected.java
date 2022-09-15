class Solution {
    public int makeConnected(int n, int[][] connections) {
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        int count = 0;
        if(connections.length<n-1)
            return -1;
        for(int i=0;i<connections.length;i++)
        {
            if(!hm.containsKey(connections[i][0]))
                hm.put(connections[i][0], new ArrayList<Integer>());
            
            hm.get(connections[i][0]).add(connections[i][1]);
            
            if(!hm.containsKey(connections[i][1]))
                hm.put(connections[i][1], new ArrayList<Integer>());
            
            hm.get(connections[i][1]).add(connections[i][0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i=0; i < n; i++){
            if(!visited.contains(i)){
                count++;
                DFS(hm, visited, i);
            }
                
            
            
        }
        return count-1;
    }
    
    public void DFS(HashMap<Integer,List<Integer>> hm, HashSet<Integer> visited, int i)
    {
        if(visited.contains(i))
            return;
        visited.add(i);
        if(hm.containsKey(i)){
            for(int c : hm.get(i)){
               DFS(hm, visited, c); 
            }
        }
    }
}