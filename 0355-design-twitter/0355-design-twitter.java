class Twitter {
    static int timestamp;
    Map<Integer, List<List<Integer>>> tweets;
    Map<Integer, Set<Integer>> follows;

    public Twitter() {
        this.timestamp = 0;
        this.tweets = new HashMap<>();
        this.follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        timestamp++;
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(Arrays.asList(timestamp, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<List<Integer>> t = new ArrayList<>();
        for (Map.Entry<Integer, List<List<Integer>>> c : tweets.entrySet()) {
            if (c.getKey() == userId) {
                List<List<Integer>> userTweets = c.getValue();
                for (int i = 0; i < userTweets.size(); i++) {
                    t.add(userTweets.get(i));
                }
            }
        }

        if(follows.containsKey(userId)){
            for(int followee : follows.get(userId)){
                if(tweets.containsKey(followee)) {
                    List<List<Integer>> ft = tweets.get(followee);
                    for(int i = 0; i < ft.size(); i++){
                        t.add(ft.get(i));
                    }
                }
            }
        }

        t.sort((a, b) -> b.get(0) - a.get(0));

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < Math.min(10, t.size()); i++){
            res.add(t.get(i).get(1));
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
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