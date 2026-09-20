class Twitter {
        private class Pair{
            int tweetId; int count;
            public Pair(int tweetId, int count){
                this.tweetId = tweetId;
                this.count = count;
            }
        }
        private static int currentTime = 0;

        private Map<Integer,HashSet<Integer>> followerMap;
        private Map<Integer,List<Pair>> tweetsMap;

        public Twitter() {
            this.followerMap = new HashMap<>();
            this.tweetsMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweetsMap.computeIfAbsent(userId, k-> new ArrayList<>());
            List<Pair> list = tweetsMap.get(userId);
            list.add(new Pair(tweetId,currentTime++));
            tweetsMap.put(userId,list);
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.count - a.count);
            tweetsMap.computeIfAbsent(userId,k-> new ArrayList<>());
            followerMap.computeIfAbsent(userId, k-> new HashSet<>(Set.of(userId)));
            for(int user:followerMap.get(userId)){
                for(Pair p:tweetsMap.get(user)){
                    pq.add(p);
                }
            }
            List<Integer> res = new ArrayList<>();
            int target = 10;
            while(target>0 && pq.size()>0){
                res.add(pq.poll().tweetId);
                target--;
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            HashSet<Integer> set = followerMap.getOrDefault(followerId,new HashSet<>(Set.of(followerId)));
            set.add(followeeId);
           followerMap.put(followerId,set);
        }

        public void unfollow(int followerId, int followeeId) {
            if(followerMap.containsKey(followerId)){
                HashSet<Integer> set = followerMap.get(followerId);
                set.remove(followeeId);
                followerMap.put(followerId,set);
            }
        }
    }