class Solution {
    public long repairCars(int[] ranks, int cars) {
        long minVal = 10000000;
        
        // Find the minimum rank
        for (int rank : ranks) {
            minVal = Math.min(minVal, rank);
        }
        
        long l = minVal, r = minVal * (long) cars * cars, mid, ans = 0;
        
        // Binary search for the minimum required time
        while (l <= r) {
            mid = (l + r) / 2;
            if (isPossible(ranks, cars, mid)) {
                ans = mid;  // Update answer
                r = mid - 1; // Try to find a smaller time
            } else {
                l = mid + 1;
            }
        }
        
        return ans;
    }
    
    // Function to check if all cars can be repaired within 'minutes'
    public boolean isPossible(int[] ranks, int cars, long minutes) {
        for (int rank : ranks) {
            cars -= (int) Math.sqrt(minutes / rank);
            if (cars <= 0) {
                return true;  // Successfully repaired all cars
            }
        }
        
        return false; // Not enough cars repaired
    }
}