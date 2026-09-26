class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s.length());
            result.append("#");
            result.append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (true) {
            int next = str.indexOf("#", index);
            if (next == -1) {
                break;
            }
            int length = Integer.parseInt(str.substring(index, next));
            result.add(str.substring(next + 1, next + length + 1));
            index = next + length + 1;
        }
        return result;
    }
}
