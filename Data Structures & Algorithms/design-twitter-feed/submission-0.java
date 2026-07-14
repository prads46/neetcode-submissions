class Twitter {

    class Tweet {
        public int tweetId;
        public int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class User {
        Set<User> followees;
        public Queue<Tweet> tweets;
        PriorityQueue<Tweet> pq;

        public User() {
            this.followees = new HashSet<>();
            this.tweets = new LinkedList<>();
            this.pq = new PriorityQueue<>((a, b) -> a.time - b.time);
            this.followees.add(this);
        }

        public void postTweet(Tweet tweet) {
            this.tweets.offer(tweet);
            if (tweets.size() > 10) {
                tweets.poll();
            }
            
        }

        public List<Integer> getNewsFeed() {
            List<Integer> res = new ArrayList<>();
            for (User followee : this.followees) {
                Queue<Tweet> q = followee.tweets;
                int n = q.size();
                for (int i = 0; i < n; i ++) {
                    Tweet tweet = q.poll();
                    if (pq.size() < 10) {
                        pq.offer(tweet);
                    } else if (pq.peek().time < tweet.time) {
                        pq.poll();
                        pq.offer(tweet);
                    }
                    q.offer(tweet);
                }
            }

            while (!pq.isEmpty()) {
                res.add(pq.poll().tweetId);
            }

            Collections.reverse(res);
            return res;
        }

        public void follow(User followee) {
            this.followees.add(followee);
        }
        
        public void unfollow(User followee) {
            this.followees.remove(followee);
        }

    }

    Map<Integer, User> data;
    int time;

    public Twitter() {
        this.data = new HashMap<>();
        this.time = 0;
    }

    public User getUser(int userId) {
        return data.computeIfAbsent(userId, k -> new User());
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.postTweet(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        return user.getNewsFeed();
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        User user = getUser(followerId);
        User followee = getUser(followeeId);

        user.follow(followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        User user = getUser(followerId);
        User followee = getUser(followeeId);

        user.unfollow(followee);
    }
}
