class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (
                (c == ')' && (stack.isEmpty() || stack.peek() != '(')) ||
                (c == '}' && (stack.isEmpty() || stack.peek() != '{')) ||
                (c == ']' && (stack.isEmpty() || stack.peek() != '['))
            ) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
