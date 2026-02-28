public class Stack{
    /**
     * Checks if a string containing brackets is balanced.
     * 
     * A string is considered balanced if every opening bracket has a corresponding
     * closing bracket of the same type in the correct order.
     * 
     * Supported bracket types:
     * - Parentheses: ( )
     * - Curly braces: { }
     * - Square brackets: [ ]
     * 
     * @param s the string to check for balanced brackets
     * @return true if all brackets in the string are properly balanced and matched,
     *         false otherwise
     */
    public boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if((ch == '(') || (ch == '{') || (ch == '[')){
                st.push(ch);
            } else {
                if(st.empty()) return false;
                char chr = st.peek();
                if((ch == ')' && chr != '(') || (ch == ']' && chr != '[') || (ch == '}' && chr != '{')){
                    return false;
                }
                st.pop();
            }
        }
        return st.empty();
    }
}