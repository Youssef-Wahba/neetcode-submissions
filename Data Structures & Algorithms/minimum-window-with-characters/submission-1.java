class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length() || t.isEmpty()) return "";
        HashMap<Character,Integer> countT = new HashMap<>(),window = new HashMap<>();
        for(Character c: t.toCharArray())
            countT.put(c,countT.getOrDefault(c,0)+1);
        int l=0,needCount=countT.size(),haveCount=0,resLen=Integer.MAX_VALUE;
        int [] resultPointer = new int[]{-1,-1};
         for(int r=0;r<s.length();r++){
             char currentChar = s.charAt(r);
             window.put(currentChar,window.getOrDefault(currentChar,0)+1);
             if(countT.containsKey(currentChar) && countT.get(currentChar).equals(window.get(currentChar))) haveCount++;
             while(haveCount == needCount){
                 int windowSize = r-l+1;
                 if(windowSize<resLen){
                     resLen = windowSize;
                     resultPointer[0] =l;
                     resultPointer[1] = r;
                 }
                 System.out.println(Arrays.toString(resultPointer));
                 char currentLeftChar = s.charAt(l);
                 window.put(currentLeftChar,window.get(currentLeftChar)-1);
                 if(countT.containsKey(currentLeftChar) && window.get(currentLeftChar)<countT.get(currentLeftChar))
                     haveCount--;
                 l++;
             }
         }
         return resLen==Integer.MAX_VALUE ? "" : s.substring(resultPointer[0],resultPointer[1]+1);
    }
}
