class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<String>();
            }
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
