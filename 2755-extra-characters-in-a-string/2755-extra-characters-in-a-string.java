// class Solution {
//     int ans = Integer.MAX_VALUE;
//    static class Node{
//         Node[] children;
//         boolean eow;
//         public Node(){
//             children = new Node[26];
//             for(int i=0; i < 26; i++){
//                 children[i] =null;
//             }
//             eow = false;
//         }
//     }
//     static Node root = new Node();
//     public static void insert(String word){
//         Node curr = root;
//         for(int i=0; i < word.length(); i++){
//             int idx = word.charAt(i) - 'a';
//             if(curr.children[idx] == null){
//                 curr.children[idx] = new Node();
//             }
//             if(i == word.length()-1){
//                 curr.children[idx].eow = true;
//             }
//             curr = curr.children[idx];
//         }
//     }
//     public static boolean search(String key){
//         Node curr = root;
//         for(int i =0; i < key.length(); i++){
//             int idx = key.charAt(i) - 'a';
//             Node nde = curr.children[idx];
//             if(node == null){
//                 ans = Math.min(ans , key.length());
//                 return false;
//             }
//             if(i == key.length()-1 && node.eow == false){
//                 ans = Math.min(ans , key.length());
//                 return false;
//             }
//             curr = curr.children[idx];
//         }
//         return true;
//     }
//     public int minExtraChar(String s, String[] dictionary) {
//         int n = s.length();
//          int m = dictonary.length;
//         for(int i =0; i <m; i++ ){
//             insert(dictionary[i]);
//         }
//         boolean res= wordbreak(s);
//         if(res) return 0;
      
        
//         return ans;
//     }
//     public static boolean wordbreak(String s){
//  if(s.length() == 0){
//            return true;;
//        }
//        for(int i =1; i <=n; i++){
//            String first = s.substring(0 , i);
//            String second = s.substring(i);
//            if(search(first)&&wordbreak(second) ){
//                return true;
//            }
//        }
//     }
// }
// class Solution {
//     static int ans = Integer.MAX_VALUE; // Make ans static

//     static class Node {
//         Node[] children;
//         boolean eow;

//         public Node() {
//             children = new Node[26];
//             for (int i = 0; i < 26; i++) {
//                 children[i] = null;
//             }
//             eow = false;
//         }
//     }

//     static Node root = new Node();

//     public static void insert(String word) {
//         Node curr = root;
//         for (int i = 0; i < word.length(); i++) {
//             int idx = word.charAt(i) - 'a';
//             if (curr.children[idx] == null) {
//                 curr.children[idx] = new Node();
//             }
//             if (i == word.length() - 1) {
//                 curr.children[idx].eow = true;
//             }
//             curr = curr.children[idx];
//         }
//     }

//     public static boolean search(String key) {
//         Node curr = root;
//         for (int i = 0; i < key.length(); i++) {
//             int idx = key.charAt(i) - 'a';
//             Node node = curr.children[idx]; // Change nde to node
//             if (node == null) {
//                 ans = Math.min(ans, key.length());
//                 return false;
//             }
//             if (i == key.length() - 1 && node.eow == false) {
//                 ans = Math.min(ans, key.length());
//                 return false;
//             }
//             curr = curr.children[idx];
//         }
//         return true;
//     }

//    public int minExtraChar(String s, String[] dictionary) {
//     int n = s.length();
//     int m = dictionary.length;
//     for (int i = 0; i < m; i++) {
//         insert(dictionary[i]);
//     }
//     ans = n; // Initialize ans to the length of the input string
//     wordbreak(s, n, 0); // Call wordbreak with an additional parameter
//     return ans;
// }

// public void wordbreak(String s, int n, int extraChars) {
//     if (s.length() == 0) {
//         ans = Math.min(ans, extraChars); // Update ans with the minimum extra characters
//         return;
//     }
//     for (int i = 1; i <= n; i++) {
//         if (i <= s.length()) {
//             String first = s.substring(0, i);
//             String second = s.substring(i);
//             if (search(first)) {
//                 wordbreak(second, n, extraChars + (i - first.length()));
//             }
//         }
//     }
// }

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         String s = "sayhelloworld";
//         String[] dictionary = {"hello", "world"};
//         int result = solution.minExtraChar(s, dictionary);
//         System.out.println("Minimum Extra Characters: " + result);
//     }
// }
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int maxVal = s.length() + 1;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, maxVal);
        dp[0] = 0;

        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 1; i <= s.length(); ++i) {
            dp[i] = dp[i - 1] + 1;
            for (int l = 1; l <= i; ++l) {
                if (dictionarySet.contains(s.substring(i - l, i))) {
                    dp[i] = Math.min(dp[i], dp[i - l]);
                }
            }
        }
        return dp[s.length()];
    }
}