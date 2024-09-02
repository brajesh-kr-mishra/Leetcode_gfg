class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length, idx = 0;
        long sum = 0;
        for (int a : chalk) {
            sum = sum + a;
        }
        k = (int)(k % sum); // Cast the result to int
        while (k > 0) {
            int t = chalk[idx % n];
            k = k - t;
            if (k >= 0)
                idx++;
        }
        return idx % n;
    }
}
