//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        //code here.
        if(n==0) return 0;
        int res =0;
        
            if(n%2==0){
                res++;
             res+= minOperation( n/2);
            }else{
               res++; 
             res+= minOperation( n-1);
            }
        
        return res;
    }
}/*Next Suggested Problem(s):
Minimum steps to minimize n as per given condition
Optimal walk
Letter Writer

 int res =0;
        while(n>0){
            if(n%2==0){
                res++;
                n /=2;
            }else{
               res++; 
               n -=1;
            }
        }
        return res;
        */