import java.util.Date;
class Node {
    public Tweet tweet;
    public Node next;
    public Node(Tweet tweet)
    {
        this.tweet = tweet;
    }
}

class Tweet {
    public int tweetId;
    public int timeStamp;
    public int userId;
    
    public Tweet(int tweetId, int userId, int time)
    {
        this.tweetId = tweetId;
        this.timeStamp = time;
        this.userId = userId;
    }
}

class User {
    public int userId;
    public HashSet<Integer> followers;
    public HashSet<Tweet> tweets;
    public Node head;
    
    public User(int userId)
    {
        this.userId = userId;
        this.followers = new HashSet<>();
        this.tweets = new HashSet<>();
        this.head = new Node(null);
    }
    
    public HashSet<Integer> getFollowers()
    {
        return this.followers;
    }
    
    public void AddTweet(Tweet tweet)
    {
        Node tweetNode = new Node(tweet);
        tweets.add(tweet);
        tweetNode.next = this.head.next;
        this.head.next = tweetNode;
    }
}

class Twitter {
    public int time= 0;
    private HashMap<Integer, User> users;
    private HashMap<Integer, Tweet> tweets;
    
    public Twitter() {
        users = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId))
        {
            User user = new User(userId);
            users.put(userId, user);
        }
        User user = users.get(userId);
        time++;
        user.AddTweet(new Tweet(tweetId, userId, time));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        if(!users.containsKey(userId))
            return newsFeed;
        
        User user = users.get(userId);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->b.tweet.timeStamp - a.tweet.timeStamp);
        
        if(user.head.next!=null)
            pq.add(user.head.next);
        
        HashSet<Integer> followers = user.getFollowers();
        
        for(int id : followers)
        {
            User u = users.get(id);
            if(u.head.next!=null)
                pq.add(u.head.next);
        }
        
        while(newsFeed.size()<10 && !pq.isEmpty())
        {
            Node n = pq.poll();
            if(n!=null && n.tweet!=null)
                newsFeed.add(n.tweet.tweetId);
            
            if(n!=null && n.next!=null)
            {
                pq.add(n.next);
            }
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId))
        {
            User user = new User(followerId);
            users.put(followerId, user);
        }
        
        if(!users.containsKey(followeeId))
        {
            User user = new User(followeeId);
            users.put(followeeId, user);
        }
        
        User user = users.get(followerId);
        user.getFollowers().add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId))
        {
            User user = users.get(followerId);
            user.getFollowers().remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */