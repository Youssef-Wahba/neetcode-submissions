class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        Character delimiter = '@';
        for(String s:strs){
            encoded.append(s.length()).append(delimiter).append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        Character delimiter = '@';
        for(int i=0;i<str.length();){
            int delimiterPosition = str.indexOf(delimiter,i);
            int strLength = Integer.parseInt(str.substring(i,delimiterPosition));
            i = delimiterPosition+1;
            decoded.add(str.substring(i,i+strLength));
            i+=strLength;
        }
        return decoded;
    }
}
