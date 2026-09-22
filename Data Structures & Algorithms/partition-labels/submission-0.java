class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), Math.max(map.getOrDefault(s.charAt(i), 0), i));
        }
        int size = 0;
        int end = 0;
        for (int i = 0; i < s.length(); ++i) {
            char current = s.charAt(i);
            int currentEnd = map.get(current);
            if (currentEnd > end) {
                end = currentEnd;
            }
            size += 1;
            if (i >= end) {
                result.add(size);
                size = 0; 
            }
        }
        return result;
    }
}
