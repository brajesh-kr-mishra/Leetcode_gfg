//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        
        // Create an array to store maximum money at each house.
        int[] dp = new int[n];
        
        // Initialize the first two elements.
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        
        // Fill the dp array using a loop.
        for (int i = 2; i < n; i++) {
            // Choose the maximum between looting the current house or skipping it.
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        
        // The final element of dp array contains the maximum money.
        return dp[n - 1];
    }
}
