/*class Solution {
    public int findTheLongestSubstring(String str) {
        Set<Character> s = new HashSet<>();
        s.add('a');
        s.add('e');
        s.add('i');
        s.add('o');
        s.add('u');
        int res = 0;
        for(int l=0; l<str.length()-1;++l ){
            int volcount =0;
            if(s.contains(str.charAt(l))) volcount++;
            for(int r= l; r< str.length(); ++r){
                if(s.contains(str.charAt(r)))  volcount++;
                if(volcount %2 ==0) res = Math.max(res, r-l);
            }
        }
        return res;
    }
}*/
class Solution {
    public int findTheLongestSubstring(String s) {
        int[] mapy = new int[32];
        Arrays.fill(mapy, -2);
        mapy[0] = -1;

        int maxLen = 0;
        int mask = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case 'a':
                    mask ^= 1;
                    break;
                case 'e':
                    mask ^= 2;
                    break;
                case 'i':
                    mask ^= 4;
                    break;
                case 'o':
                    mask ^= 8;
                    break;
                case 'u':
                    mask ^= 16;
                    break;
            }

            int prev = mapy[mask];
            if (prev == -2) {
                mapy[mask] = i;
            } else {
                maxLen = Math.max(maxLen, i - prev);
            }
        }

        return maxLen;
    }
}