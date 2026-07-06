class Solution {
      public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            result += str.length() + "#" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        int position = 0;
        int temp;
        List<String> result = new ArrayList<>();
        do {
            temp = str.indexOf('#', position);
            if (temp == -1) {
                break;
            }
            int length = Integer.parseInt(str.substring(position, temp));
            position = temp + length + 1;
            result.add(str.substring(temp + 1, temp + length + 1));
        } while (temp != -1);
        return result;
    }
    
    // public String encode(List<String> strs) {
    //     String result = "";
    //     for (String s : strs) {
    //         result += s.length() + "#" + s;
    //     }
    //     return result;
    // }

    // public List<String> decode(String str) {
    //     int i = 0;
    //     List<String> result = new ArrayList<>();
    //     while (i < str.length()) {
    //         int j = str.indexOf('#', i);
    //         int length = Integer.parseInt(str.substring(i, j));
    //         i = j + length + 1;
    //         result.add(str.substring(j + 1, j + length + 1));
    //     }
    //     return result;
    // }

    // public String encode(List<String> strs) {
    //     String result = "";
    //     for (String s : strs) {
    //         result += s.length() + "#" + s;
    //     }
    //     return result;
    // }

    // public List<String> decode(String str) {
    //     List<String> result = new ArrayList<>();
    //     int i = 0;
    //     while (i < str.length()) {
    //         int j = str.indexOf("#", i);
    //         int length = Integer.parseInt(str.substring(i, j));
    //         i = j + 1 + length;
    //         result.add(str.substring(j + 1, j + 1 + length));
    //     }
    //     return result;
    // }
}
