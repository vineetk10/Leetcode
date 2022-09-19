class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> mat = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> memo = new HashSet<>();
        for(int i=0;i<numCourses;i++)
        {
            List<Integer> a = new ArrayList<>();
            mat.add(a);
        }
        
        for(int i=0;i<prerequisites.length;i++)
        {
            mat.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i=0;i<numCourses; i++)
        {
            if(!CanFinish(numCourses, visited, memo, mat, i))
                return false;
        }
        return true;
    }
    
    public static boolean CanFinish(int numCourses, HashSet<Integer> visited, HashSet<Integer> memo, List<List<Integer>> mat, int index)
    {
        if(visited.contains(index))
            return false;
        // if(memo.contains(index))
        //     return true;
        if(mat.get(index).size()==0)
            return true;
        visited.add(index);
        for(int i=0;i<mat.get(index).size();i++)
        {
            if(!CanFinish(numCourses, visited, memo, mat, mat.get(index).get(i)))
               return false;
        }
        visited.remove(index);
        mat.get(index).clear();
        return true;
    }
}