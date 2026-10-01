class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> internalMap = map.getOrDefault(key, new TreeMap<Integer, String>());
        internalMap.put(timestamp, value);
        map.put(key, internalMap);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> internalMap = map.get(key);
        String value = "";
        if (internalMap == null) {
            return value;
        }
        for (Map.Entry<Integer, String> entry : internalMap.entrySet()) {
            if (entry.getKey() > timestamp) {
                break;
            }
            value = entry.getValue();
        }
        return value;
    }
}
