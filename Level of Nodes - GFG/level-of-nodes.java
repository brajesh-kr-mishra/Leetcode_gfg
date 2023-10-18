//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        // Create an array to keep track of visited nodes and initialize it.
        boolean[] visited = new boolean[V];
        
        // Create a queue for BFS and initialize it.
        Queue<Integer> queue = new LinkedList<>();
        
        // Enqueue the source node (node 0) and mark it as visited.
        queue.add(0);
        visited[0] = true;
        
        // Initialize the level to 0.
        int level = 0;
        
        // Start BFS traversal.
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level.
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll(); // Dequeue the current node.
                
                // Check if the current node is the target node (X).
                if (current == X) {
                    return level; // Return the level if found.
                }
                
                // Traverse the adjacent nodes of the current node.
                for (int neighbor : adj.get(current)) {
                    // If the neighbor has not been visited, mark it and enqueue it.
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            
            level++; // Move to the next level.
        }
        
        // If the target node X is not found, return -1.
        return -1;
    }
}
