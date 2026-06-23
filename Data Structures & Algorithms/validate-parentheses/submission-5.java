class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (!stack.isEmpty()) {
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
