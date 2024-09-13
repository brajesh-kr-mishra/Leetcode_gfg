class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m =  queries.length;
        int[] res = new int[m];
        for(int i =0; i< m; ++i){
            res[i] = helper(arr, queries[i][0], queries[i][1] );
        }
        return res;
    }
    int helper(int[] arr , int l , int r){
        int xor = 0;
        for(int i =l; i<= r; ++i){
            xor = xor ^arr[i];
        }
        return xor;
    }
}