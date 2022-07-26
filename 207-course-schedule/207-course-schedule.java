class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> arr = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> memo = new HashSet<>();
        for(int i=0;i<numCourses;i++)
        {   
            List<Integer> a = new ArrayList<>();
            arr.add(a);
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i=0;i<arr.size();i++)
        {
            if(memo.contains(i))
                continue;
            if(!CanFinish(visited,memo, arr, i))
            {
                return false;
            }
            memo.add(i);
        }
        return true;
    }
    
    public boolean CanFinish(HashSet<Integer> visited, HashSet<Integer> memo, List<List<Integer>> arr, int curr)
    {
        if(visited.contains(curr))
            return false;
        if(memo.contains(curr))
            return true;
        visited.add(curr);
        for(int i = 0;i<arr.get(curr).size();i++)
        {
             if(!CanFinish(visited,memo,arr , arr.get(curr).get(i)))
                 return false;
        }
        memo.add(curr);
        visited.remove(curr);
        return true;
    }
}



























//  int mat[][] = new int[numCourses][numCourses];
//         HashSet<Integer> hs = new HashSet<>();
//             boolean[] visited = new boolean[numCourses];
//         for(int i=0;i<prerequisites.length;i++)
//         {
//             if(prerequisites[i][0]==prerequisites[i][1])
//                 return false;
//             mat[prerequisites[i][0]][prerequisites[i][1]] = 1;
//         }
//         for(int i=0;i<prerequisites.length;i++)
//         {
//             // if(hs.contains(i))
//             //     continue;

//             if(!CheckCycle(mat,prerequisites[i][0],visited,true,hs))
//                 return false;
//             // hs.add(i);
//         }
//          return true;
//     }
    
//     public static boolean CheckCycle(int[][] mat, int start, boolean[] visited, boolean res, HashSet<Integer> hs)
//     {
//         if(visited[start]){
//             return false;
//         }
//        if(hs.contains(start))
//                 return true;
//         visited[start] = true;
//         for(int i=0;i<mat.length;i++)
//         {
            
//             if(mat[start][i]==1)
//             {
//                 if(!CheckCycle(mat,i,visited, true,hs))
//                     return false;
//             }
            
//         }
//         hs.add(start);
//         visited[start] = false;
//        return true;
//     }