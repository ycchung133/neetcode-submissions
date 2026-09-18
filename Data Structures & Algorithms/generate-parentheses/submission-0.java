class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        List<Integer> opens = new ArrayList<>();
        List<Integer> closes = new ArrayList<>();
        temp.add("");
        opens.add(0);
        closes.add(0);
        while (!temp.isEmpty()) {
            String current = temp.remove(0);
            int open = opens.remove(0);
            int close = closes.remove(0);

            if (current.length() == 2 * n) {
                results.add(current);
                continue;
            }

            if (open < n) {
                temp.add(current + "(");
                opens.add(open + 1);
                closes.add(close);
            }
            
            if (close < open) {
                temp.add(current + ")");
                opens.add(open);
                closes.add(close + 1);
            }

        }
        return results;
    }
}
