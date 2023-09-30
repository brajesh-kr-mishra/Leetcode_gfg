//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to return list of integers that form the boundary 
    // traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Traverse the top boundary from left to right
        for (int i = 0; i < m; i++) {
            ans.add(matrix[0][i]);
        }
        
        // Traverse the right boundary from top to bottom
        for (int i = 1; i < n; i++) {
            ans.add(matrix[i][m - 1]);
        }
        
        // Traverse the bottom boundary from right to left if there are more than one row
        if (n > 1) {
            for (int i = m - 2; i >= 0; i--) {
                ans.add(matrix[n - 1][i]);
            }
        }
        
        // Traverse the left boundary from bottom to top if there are more than one column
        if (m > 1) {
            for (int i = n - 2; i > 0; i--) {
                ans.add(matrix[i][0]);
            }
        }

        return ans;
    }
}
