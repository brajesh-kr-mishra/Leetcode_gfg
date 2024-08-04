import java.util.Arrays;

class Solution {
    int mod = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int N = (n * (n + 1)) / 2;
        int[] temp = new int[N];
        int idx = 0;

        // Calculate all subarray sums
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int tempsum = findsum(nums, i, j);
                temp[idx] = (tempsum) % mod;
                idx++;
            }
        }

        // Sort the subarray sums
        Arrays.sort(temp);

        // Calculate the sum of the elements from `left` to `right`
        int res = 0;
        for (int i = left - 1; i < right; ++i) {
            res = (res + temp[i]) % mod;
        }

        return res;
    }

    public int findsum(int[] nums, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; ++i) { // Corrected to include nums[r]
            sum = (sum + nums[i]) % mod;
        }
        return sum;
    }
}
