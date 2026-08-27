class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (String s : strs) {
            result += s.length() + "#" + s;
        }
        return result;
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while (true) {
            int next = str.indexOf("#", i);
            if (next == -1) {
                break;
            }
            int length = Integer.parseInt(str.substring(i, next));
            i = next + length + 1;
            result.add(str.substring(next + 1, i));
        }
        return result;
    }
}
