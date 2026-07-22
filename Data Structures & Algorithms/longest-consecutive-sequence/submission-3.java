class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);
        int lcs = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int maxLcs = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    maxLcs++;
                }
                lcs = Math.max(lcs, maxLcs);
            }
        }
        return lcs;
    }
}
