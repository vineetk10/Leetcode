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
import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    public static Deque<NestedInteger> dq;
    public NestedIterator(List<NestedInteger> nestedList) {
        dq = new LinkedList<>();
        
        for(int i=nestedList.size()-1;i>=0;i--)
        {
            dq.addFirst(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(!hasNext())
              throw new NoSuchElementException();
        return dq.removeFirst().getInteger();
    }
    
    private void makeTopInteger(){
        
        if(dq.size()>0)
            if(dq.peek().isInteger())
            return;
        else
        {
            NestedInteger ni = dq.removeFirst();
            for(int i=ni.getList().size()-1;i>=0;i--)
            {
                if(ni.getList().size()>0)
                    dq.addFirst(ni.getList().get(i));
            }
             makeTopInteger();
        }
    }
    @Override
    public boolean hasNext() {
        makeTopInteger();
        return !dq.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */