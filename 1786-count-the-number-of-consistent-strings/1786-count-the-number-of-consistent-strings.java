class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(int i =0; i< allowed.length(); ++i){
            char ch = allowed.charAt(i);
            set.add(ch);
        }
        int res =0;
        for(int i=0; i< words.length; ++i){
           if(helper(words[i], set)){
            res++;
           }
        }
        return  res;
    }
    boolean helper(String str, Set<Character> set){
        for(int i =0; i< str.length(); ++i){
            if(!set.contains(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}