class Solution {
    LinkedList<Integer> stack = new LinkedList<>();

    public int evalRPN(String[] tokens) {

        for (String s : tokens) {
            if (s.equals("+")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(a + b);
            } else if (s.equals("-")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b - a);
            } else if (s.equals("*")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(a * b);
            } else if (s.equals("/")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }

}
