//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> safeNodes = new ArrayList<>();
        int[] color = new int[V]; // 0 - unvisited, 1 - visiting, 2 - visited
        
        for (int i = 0; i < V; i++) {
            if (isSafeNode(i, adj, color)) {
                safeNodes.add(i);
            }
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
    
    private boolean isSafeNode(int node, List<List<Integer>> adj, int[] color) {
        if (color[node] == 1) return false; // If visiting, it's not safe
        if (color[node] == 2) return true;  // If visited, it's safe
        
        color[node] = 1; // Mark as visiting
        
        for (int neighbor : adj.get(node)) {
            if (!isSafeNode(neighbor, adj, color)) {
                return false; // If a neighbor is not safe, this node is not safe.
            }
        }
        
        color[node] = 2; // Mark as visited
        return true;
    }
}
