class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        
        // Copy the original array to temp
        for (int i = 0; i < n; ++i) {
            temp[i] = arr[i];
        }
        
        // Sort the array
        Arrays.sort(arr);
        
        // Map to store ranks
        Map<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        
        // Assign ranks based on sorted array
        for (int k = 0; k < n; ++k) {
            if (!hm.containsKey(arr[k])) {
                hm.put(arr[k], rank);
                rank++;
            }
        }
        
        // Create the result array
        int[] res = new int[n];
        for (int j = 0; j < n; ++j) {
            res[j] = hm.get(temp[j]);  // Use temp[j] to get the rank from the map
        }
        
        return res;
    }
}
