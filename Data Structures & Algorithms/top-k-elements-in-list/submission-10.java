class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        // Calculate frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create min heap
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
    
    // public int[] topKFrequent(int[] nums, int k) {
    //     // Get frequency for each num.
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int top = 0;
    //     for (int i : nums) {
    //         if (!map.containsKey(i)) {
    //             map.put(i, 0);
    //         }
    //         int times = map.get(i) + 1;
    //         map.put(i, times);
    //         if (top < times) {
    //             top = times;
    //         }
    //     }

    //     // Convert to buckets
    //     List<Integer>[] buckets = new List[top + 1]; 
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         int bucketIndex = entry.getValue();
    //         if (buckets[bucketIndex] == null) {
    //             buckets[bucketIndex] = new ArrayList<>();
    //         }
    //         buckets[bucketIndex].add(entry.getKey());
    //     }

    //     // Get top k frequent num.
    //     int[] result = new int[k];
    //     int count = 0;
    //     for (int i = buckets.length - 1;i >= 0; --i) {
    //         if (buckets[i] == null) {
    //             continue;
    //         }
    //         for (int j = 0; j < buckets[i].size(); ++j) {
    //             result[count] = buckets[i].get(j);
    //             count++;
    //             if (count >= k) {
    //                 return result;
    //             }
    //         }
    //     }
    //     return result;
    // }


    // public int[] topKFrequent(int[] nums, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int top = 0;
    //     for (int i : nums) {
    //         if (!map.containsKey(i)) {
    //             map.put(i, 0);
    //         }
    //         int times = map.get(i) + 1;
    //         map.put(i, times);
    //         if (top < times) {
    //             top = times;
    //         }
    //     }
    //     List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
    //     entries.sort((a, b) -> b.getValue() - a.getValue());
    //     int[] result = new int[k];
    //     for (int i = 0; i < k; ++i) {
    //         result[i] = entries.get(i).getKey();
    //     }
    //     return result;
    // }

    // public int[] topKFrequent(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     HashMap<Integer, Integer> h = new HashMap<>();
    //     for (int i : nums) {
    //         if (!h.containsKey(i)) {
    //             h.put(i, 0);
    //         }
    //         h.put(i, h.get(i) + 1);
    //     }
        
    //     List<Integer> output = new ArrayList();
    //     for (int i = 0; i < k; ++i) {
    //         int max = 0;
    //         int num = -1;
    //         for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
    //             if (entry.getValue() > max) {
    //                 max = entry.getValue();
    //                 num = entry.getKey();
    //             }
    //         }
    //         output.add(num);
    //         h.remove(num);
    //     }
    //     return output.stream().mapToInt(Integer::intValue).toArray();
    // }
}
