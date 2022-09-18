class HitCounter {
    Deque<int[]> dq;
    int total;
    
    public HitCounter() {
        dq = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        if(dq.isEmpty() || dq.peekFirst()[0]!=timestamp)
            dq.add(new int[]{timestamp, 1});
        else
        {
            int prevCount = dq.peekFirst()[1];
            dq.peekLast()[1]+=1;
        }
        this.total++;
    }
    
    public int getHits(int timestamp) {
        while(!this.dq.isEmpty())
        {
            int diff = timestamp - dq.peekFirst()[0];
            if(diff>=300)
            {
                this.total -= this.dq.peekFirst()[1];
                this.dq.removeFirst();
            }
            else 
                break;
        }
        return this.total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */