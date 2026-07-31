class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,max=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(r-l+1-Collections.max(map.values())>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return max;
}
}
