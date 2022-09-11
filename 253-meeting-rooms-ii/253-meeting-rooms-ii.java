
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int count = 0;
        List<int[]> list = new ArrayList<>(); 
        for(int arr[] : intervals)
        {
            list.add(new int[]{arr[0], -1});
            list.add(new int[]{arr[1], 1});
        }
        
        Collections.sort(list, (a,b)->a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        int result = 0;
        for(int i=0;i<list.size();i++)
        {
            int a[]= list.get(i);
            count -= a[1];
            result = Math.max(result, count);
        }
        return result;
        /*
        LinkedHashMap<Integer, List<Integer>> meetings = new LinkedHashMap<>();
        ArrayList<Interval> arr = new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            arr.add(new Interval(intervals[i][0],intervals[i][1]));
        }
        
        Collections.sort(arr,(a,b)->a.start-b.start);
        
        List<Integer> l = new ArrayList<>();
        l.add(arr.get(0).end);
        meetings.put(1, l);
        
        for(int i=1;i<arr.size();i++)
        {
            int start = arr.get(i).start;
            int end = arr.get(i).end;
             boolean assigned = false;
            for(Map.Entry<Integer,List<Integer>> map : meetings.entrySet())
            {
               
                List<Integer> l1 = map.getValue();
                if(start >= l1.get(l1.size()-1))
                {
                    assigned = true;
                    l1.add(end);
                    meetings.put(map.getKey(), l1);
                    break;
                }
            }
            if(!assigned)
            {
                List<Integer> l2 = new ArrayList<>();
                l2.add(end);
                meetings.put(meetings.size()+1, l2);
            }
                
        }
        
        return meetings.size();
        */
    }
}