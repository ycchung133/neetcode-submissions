class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }
        return result;
    }

    // public int[] dailyTemperatures(int[] temperatures) {
    //     int max = temperatures[0];
    //     int[] result = new int[temperatures.length];
    //     for (int i = 0; i < temperatures.length; ++i) {
    //         int index  = 0;
    //         for (int j = i; j < temperatures.length; ++j) {
    //             if (temperatures[j] > temperatures[i]) {
    //                 index = j - i;
    //                 break;
    //             }
    //         }
    //         result[i] = index;
    //     }
    //     return result;
    // }
}
