//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		
	    while(t-- >0)
	    {
	        String inputLine[] = br.readLine().trim().split(" ");
	        
	        //taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            
            //calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
	    }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int N, int S)
    {
        // add your code here
        StringBuilder ans = new StringBuilder();
        //if(S ==0 && N >1) return "-1";
        for(int i =0; i < N; i++){
           if(S>9){
                ans.append('9');
               S -= 9;
           } else{
              ans.append(Integer.toString(S));

               S -= S;
           }
        }
        if(S!=0){
            return "-1";
        }
        return ans.toString();
    }
}


