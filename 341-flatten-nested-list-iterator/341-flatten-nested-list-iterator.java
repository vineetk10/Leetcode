/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    public int index = 0;
    public List<Integer> flattenedList;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenedList = new ArrayList<>();
        
        for(int i=0;i<nestedList.size();i++)
        {
            FlattenList(nestedList, i);
        }
        
        System.out.println(flattenedList.toString());
        
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return flattenedList.get(index++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return index<flattenedList.size()?true: false;
    }
    
    public void FlattenList(List<NestedInteger> nestedList, int index)
    {
        if(index == nestedList.size())
            return;
        
        if(nestedList.get(index).isInteger())
        {
            // System.out.println(nestedList.get(index).getInteger()+" "+index);
            this.flattenedList.add(nestedList.get(index).getInteger());
            
        } 
        else
        {
            for(int i=0;i<nestedList.get(index).getList().size();i++)
            {
                // System.out.println("Hi"+index);
                FlattenList(nestedList.get(index).getList(), i);
            }
        }
       
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */