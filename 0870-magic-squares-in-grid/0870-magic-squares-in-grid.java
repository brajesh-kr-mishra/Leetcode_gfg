import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if (row < 3 || col < 3) return 0;
        int ans = 0;
        for (int i = 0; i <= row - 3; ++i) {
            for (int j = 0; j <= col - 3; ++j) {
                if (helper(i, j, grid)) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    boolean helper(int i, int j, int[][] grid) {
        // Check if each number is in the range 1-9 and unique
        Set<Integer> s = new HashSet<>();
        for (int l = i; l < i + 3; ++l) {
            for (int r = j; r < j + 3; ++r) {
                if (grid[l][r] < 1 || grid[l][r] > 9 || !s.add(grid[l][r])) {
                    return false;
                }
            }
        }

        int s1 = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        return (s1 == grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2]) &&
               (s1 == grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2]) &&
               (s1 == grid[i][j] + grid[i+1][j] + grid[i+2][j]) &&
               (s1 == grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1]) &&
               (s1 == grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2]) &&
               (s1 == grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]) &&
               (s1 == grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j]);
    }
}
