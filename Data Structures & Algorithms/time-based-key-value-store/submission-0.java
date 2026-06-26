class TimeMap {
    HashMap<String, List<Node>> map = new HashMap<>();

    class Node {
        int timestamp;
        String value;
    }

    public TimeMap() {

    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>());   // 沒有就建空 list
        Node node = new Node();
        node.timestamp = timestamp;
        node.value = value;
        map.get(key).add(node);  
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        List<Node> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String ans = "";       
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value;        // 合法候選,先記住
                left = mid + 1;                   // 但右邊可能有更大的 timestamp → 往右
            } else {
                right = mid - 1;                  // mid 太大 → 往左
            }
        }
        return ans;
    }

}
