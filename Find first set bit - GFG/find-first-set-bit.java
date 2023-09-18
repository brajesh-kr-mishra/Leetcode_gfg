//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // Function to find the position of the first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        int count = 0;
        
        // Check each bit starting from the least significant bit (LSB).
        while ((n != 0) && ((n & 1) != 1)){
            count++;
            n = n >> 1;
        }
        
        // If n is not 0, it means a set bit was found.
        // Return the position of the first set bit (1-based index).
        if (n != 0) {
            return count + 1;
        } else {
            // If n is 0, it means there are no set bits.
            return 0;
        }
    }
}
