class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; ++i) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int indexToPop = stack.pop();
                results[indexToPop] = i - indexToPop;
            }
            stack.push(i);
        }
        return results;
    }
}
