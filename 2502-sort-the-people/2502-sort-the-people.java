class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer ,String> hm = new HashMap<>();
        int n =  heights.length;
        for(int i =0; i<n; ++i){
            hm.put(heights[i], names[i]);

        }
        Arrays.sort(heights);
        String[] res = new String[n];
        int idx =0;
        for(int i = n-1; i>=0; --i){
          res[idx] = hm.get(heights[i]);
          idx++;
        }
        return res;
    }
}