class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegrees = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize the graph and calculate in-degrees.
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegrees[to]++;
        }
        
        int champion = -1;
        int count = 0;
        
        // Find the node(s) with no incoming edges (potential champion).
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                champion = i;
                count++;
                if (count > 1) {
                    return -1; // Multiple potential champions, no unique champion.
                }
            }
        }
        
        return champion;
    }
}
