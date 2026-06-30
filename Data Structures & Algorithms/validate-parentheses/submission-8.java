class Solution {
    public boolean isValid(String s) {
    
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (
                (c == ')' &&  (stack.isEmpty() || '(' != stack.peek()))
                 || (c == ']' && (stack.isEmpty() || '[' != stack.peek()))
                 || (c == '}' && (stack.isEmpty() || '{' != stack.peek()))) {
                return false;
            } else {
                stack.pop();
            }
            
        }

        return stack.size() == 0;
    } 





































    // public boolean isValid(String s) {
    //     LinkedList<Character> stack = new LinkedList<>();
    //     for (char c : s.toCharArray()) {
    //         if (c == '(' || c == '{' || c == '[') {
    //             stack.push(c);
    //         }
    //         if (!stack.isEmpty()) {
    //             if (c == ')' && stack.pop() != '(') {
    //                 return false;
    //             }
    //             if (c == '}' && stack.pop() != '{') {
    //                 return false;
    //             }
    //             if (c == ']' && stack.pop() != '[') {
    //                 return false;
    //             }
    //         } else {
    //             return false;
    //         }
    //     }
    //     return stack.isEmpty();
    // }
}
