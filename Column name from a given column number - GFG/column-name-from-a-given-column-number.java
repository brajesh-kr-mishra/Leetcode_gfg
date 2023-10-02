//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution {
    String colName(long n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            // Reduce n by 1 since Excel columns start from 1, not 0.
            n--;

            // Calculate the remainder, which represents the current letter.
            int remainder = (int) (n % 26);

            // Convert the remainder to a character and append it to the result.
            char currentLetter = (char) ('A' + remainder);
            sb.insert(0, currentLetter);

            // Update n with the quotient for the next iteration.
            n /= 26;
        }

        return sb.toString();
    }
}
