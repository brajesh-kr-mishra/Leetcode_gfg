class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m = grid.length;
        int[] temp = new int[m * m];
        int[] res = new int[2];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int a = grid[i][j];
                temp[a - 1]++;
            }
        }
        
        for (int i = 0; i < m * m; i++) {
            if (temp[i] == 0) {
                res[1] = i + 1;
            } else if (temp[i] == 2) {
                res[0] = i + 1;
            }
        }
        
        return res;
    }
}
