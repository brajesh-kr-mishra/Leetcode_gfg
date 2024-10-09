class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0, n = s.length();
        for(int i = 0; i < n; ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            } else if(ch == ')'){
                if(!st.isEmpty() && st.peek() == '('){  // Corrected usage of peek()
                    st.pop();
                } else {
                    count++;
                }
            }
        }
        return count + st.size();
    }
}
