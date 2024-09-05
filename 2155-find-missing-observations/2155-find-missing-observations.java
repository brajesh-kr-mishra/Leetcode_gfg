class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int m = rolls.length, sum1 = 0, sum2 = 0;
        
        // Calculate the sum of the observed rolls
        for (int a : rolls) {
            sum1 += a;
        }

        // Calculate the total sum needed to achieve the target mean
        sum2 = (mean * (m + n)) - sum1;

        // Check if the required sum for the missing rolls is feasible
        if (sum2 < n || sum2 > 6 * n) {
            return new int[] {};  // Impossible to achieve the mean
        }

        // Fill the result array with the base value
        int baseValue = sum2 / n;
        int remainder = sum2 % n;

        // Distribute the remainder across the result array
        for (int i = 0; i < n; i++) {
            res[i] = baseValue + (i < remainder ? 1 : 0);
        }

        return res;
    }
}
