/*class Solution {
    public String shortestPalindrome(String s) {
        int n  = s.length();
        int  L = 0, R =n-1;
        String t = s;
        StringBuilder sb = new StringBuilder(s);
           while(L<R){
            if(s.charAt(L) == t.charAt(R)){
                L++; R--;
            }else{
                if(L==0){
                    sb.insert(0, t.charAt(R));
                }else{
                  sb.insert(L-1, t.charAt(R));
                }
                 t = sb.toString(); 
                 L++;
            }

           }
           return sb.toString();

    }
}*/class Solution {
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        
        // Find the longest palindrome starting from index 0
        for (int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(reverse.substring(i))) {
                // Prepend the non-palindromic part from the reversed string
                return reverse.substring(0, i) + s;
            }
        }
        
        return "";
    }
}
