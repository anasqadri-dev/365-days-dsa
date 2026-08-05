public class Day216 {
    class Tweet {
        int tweetId;
        int time;
        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    private HashMap<Integer, List<Tweet>> userTweets;
    private HashMap<Integer, HashSet<Integer>> following;
    private int currentTime;
    public Day216() {
        userTweets = new HashMap<>();
        following = new HashMap<>();
        currentTime = 0;
    }
    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId, currentTime));
        currentTime++;
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                (firstTweet, secondTweet) -> secondTweet.time - firstTweet.time
        );
        if (userTweets.containsKey(userId)) {
            maxHeap.addAll(userTweets.get(userId));
        }
        if (following.containsKey(userId)) {
            for (int followeeId : following.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    maxHeap.addAll(userTweets.get(followeeId));
                }
            }
        }
        while (!maxHeap.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(maxHeap.poll().tweetId);
        }
        return newsFeed;
    }
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId))
            following.get(followerId).remove(followeeId);
    }
}