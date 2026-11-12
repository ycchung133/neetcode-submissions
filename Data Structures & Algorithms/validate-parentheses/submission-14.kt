class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>();
        for (c in s) {
            if (c == '(' || c == '{' || c == '[') {
                stack.addLast(c);
            } else {
                val expected = when (c) {
                    ')' -> '('
                    '}' -> '{'
                    ']' -> '['
                    else -> return false
                }

                if (stack.lastOrNull() != expected) return false
                stack.removeLast()
            }
        }
        return stack.isEmpty()
    }
}
