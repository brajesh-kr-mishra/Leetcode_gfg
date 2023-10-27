//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String str) {
        //your code here
        if(str == null || str.length() == 0) {
      return 0;
    }
    
    return str.length() - lpsBottomUp(str, str.length());
    }
     public static int lpsBottomUp(String str, int n) {
    int[][] arr = new int[n][n];
    
    for (int i = 0; i < str.length(); i++) {
      arr[i][i] = 1;
    }
      
    for(int i = n - 2; i >= 0; i--) {
      for(int j = i + 1; j < n; j++) {
        
        if(str.charAt(i) == str.charAt(j)) {
          arr[i][j] = 2 + arr[i + 1][j - 1];
        } else {
          arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
        }
      }
    }
    
    return arr[0][n - 1];
  }
}