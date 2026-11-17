class MinStack() {
    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        if (minStack.isEmpty()) {
            minStack.addLast(`val`)
        } else {
            minStack.addLast(minOf(minStack.last(), `val`))
        }
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
