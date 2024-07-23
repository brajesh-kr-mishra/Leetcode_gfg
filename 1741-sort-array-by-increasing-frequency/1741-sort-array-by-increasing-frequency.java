class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                int compare =  a.getValue().compareTo(b.getValue());
                if(compare == 0) {
                    compare = b.getKey().compareTo(a.getKey());
                }
                return compare;
            }
        }) ;


        int[] res = new int[nums.length];
        int idx = 0;
        for(int i=0; i<list.size(); i++) {
            Map.Entry<Integer, Integer> e = list.get(i);
            int val = e.getKey();
            int freq = e.getValue();
            for(int j=0; j<freq; j++) {
                res[idx++] = val;
            }
        }
        return res;
    }
}