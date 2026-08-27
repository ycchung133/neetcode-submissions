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
    

}
