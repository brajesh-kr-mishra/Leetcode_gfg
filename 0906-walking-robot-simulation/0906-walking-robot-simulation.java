import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions represent North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0; // Start facing North
        int x = 0, y = 0;
        int maxDistance = 0;

        // Convert obstacles array to a set of strings for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands) {
            if (command == -2) { // Turn left
                dirIndex = (dirIndex + 3) % 4;
            } else if (command == -1) { // Turn right
                dirIndex = (dirIndex + 1) % 4;
            } else { // Move forward
                int[] dir = directions[dirIndex];
                while (command-- > 0) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (!obstacleSet.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance, x * x + y * y);
                    } else {
                        break; // Stop if there's an obstacle
                    }
                }
            }
        }
        return maxDistance;
    }
}
