class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        if (A.length > B.length) { A = nums2; B = nums1; } // A is shorter

        int m = A.length, n = B.length;
        int total = m + n, half = (total + 1) / 2;
        int l = 0, r = m; // note: r = m, not m - 1

        while (l <= r) {
            int i = l + (r - l) / 2; // partition in A: i elements go left
            int j = half - i;        // partition in B

            int aLeft  = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int aRight = i < m ? A[i]     : Integer.MAX_VALUE;
            int bLeft  = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int bRight = j < n ? B[j]     : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 0) {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                } else {
                    return Math.max(aLeft, bLeft);
                }
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return -1;
    }
}

