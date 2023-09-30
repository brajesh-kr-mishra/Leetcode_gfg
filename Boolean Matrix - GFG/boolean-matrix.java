//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    void booleanMatrix(int matrix[][])
    {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Arrays to keep track of rows and columns to be modified
        int[] rowMarked = new int[m];
        int[] colMarked = new int[n];
        
        // Mark rows and columns to be modified based on 1s in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rowMarked[i] = 1;
                    colMarked[j] = 1;
                }
            }
        }
        
        // Update the matrix based on the marked rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowMarked[i] == 1 || colMarked[j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
/*Next Suggested Problem(s):
Rotate by 90 degree
Row with max 1s
Rotate a 2D array without using extra space*/