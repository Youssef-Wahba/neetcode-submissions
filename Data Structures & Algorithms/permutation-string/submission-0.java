class Solution {
    public boolean checkInclusion(String s1, String s2) {
                if(s1.length()>s2.length()) return false;
        int k = s1.length()-1;
        int[] originalFreq = new int[26];
        int[] currentFreq = new int[26];
        for(Character c:s1.toCharArray())originalFreq[c-'a']++;
        for(int i=k;i<s2.length();i++){
            Arrays.fill(currentFreq,0);
            for(Character c: s2.substring(i-k,i+1).toCharArray()) currentFreq[c-'a']++;
            if(Arrays.equals(originalFreq,currentFreq)) return true;
        }
        return false;
    }
}
