//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution
{
    ArrayList<Integer> rotate(int N, int D)
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Convert N to a 16-bit binary string
        String binaryStr = String.format("%16s", Integer.toBinaryString(N)).replace(' ', '0');
        
        // Ensure that D is within the range [0, 16)
        D = D % 16;
        
        // Perform left rotation
        String leftRotatedStr = binaryStr.substring(D) + binaryStr.substring(0, D);
        int leftRotated = Integer.parseInt(leftRotatedStr, 2);
        result.add(leftRotated);
        
        // Perform right rotation
        String rightRotatedStr = binaryStr.substring(16 - D) + binaryStr.substring(0, 16 - D);
        int rightRotated = Integer.parseInt(rightRotatedStr, 2);
        result.add(rightRotated);
        
        return result;
    }
}
