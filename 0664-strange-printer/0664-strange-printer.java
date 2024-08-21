class Solution {
    public int strangePrinter(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i =0; i < n ; i++){
            dp[i][i] =1;

        }
        for(int len =2; len <= n; len++){
            for(int i =0; i +len <= n; i++){
                int j = i +len -1;
                dp[i][j] = j-i +1;
                for(int k =i; k <j; k++){
                    int cnt = dp[i][k] + dp[k+1][j];
                    if(arr[k] == arr[j]){
                        cnt--;
                    }
                    dp[i][j] = Math.min(cnt , dp[i][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}