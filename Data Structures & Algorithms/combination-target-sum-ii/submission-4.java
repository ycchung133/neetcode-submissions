class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> temp = new ArrayList<>();
        HashSet<List<Integer>> newTemp = new HashSet<>();
        HashSet<List<Integer>> results = new HashSet<>();
        temp.add(new ArrayList<>());
        if (target == 0) {
            results.add(new ArrayList<>());
            return new ArrayList<>(results);
        }
        Arrays.sort(candidates);
        for (int num : candidates) {
            for (List<Integer> subset : temp) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                int sum = 0;
                for (int j = 0; j < newSubset.size(); ++j) {
                    sum += newSubset.get(j);
                }
                if (sum < target) {
                    newTemp.add(newSubset);
                } else if (sum == target) {
                    newTemp.add(newSubset);
                    results.add(newSubset);
                }
            }
            for (List<Integer> subset : newTemp) {
                temp.add(subset);
            }
            newTemp.clear();
        }
        return new ArrayList<>(results);
    }
}
