class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int[] arr = new int[26];
        for(String s: strs){
            Arrays.fill(arr,0);
            for(char c: s.toCharArray())
                arr[c-'a']++;
            StringBuilder sb = new StringBuilder();
            for(int count: arr)
                sb.append("#"+count);
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
