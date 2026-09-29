class MinStack {

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayDeque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(val < minStack.peek() ? val : minStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
