class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minOps = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n - k; i++) {
            int countWhite = 0;
            
            // Count white blocks in the current window of size k
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    countWhite++;
                }
            }
            
            minOps = Math.min(minOps, countWhite);
        }
        
        return minOps;
    }
}
