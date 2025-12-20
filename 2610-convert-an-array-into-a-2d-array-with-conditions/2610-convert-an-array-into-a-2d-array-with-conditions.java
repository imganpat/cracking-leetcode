class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        while(freq.size() > 0){
            List<Integer> row = new ArrayList<>();
            for(Integer key: new ArrayList<>(freq.keySet())){
                row.add(key);
                freq.put(key, freq.get(key) - 1);

                if(freq.get(key) == 0){
                    freq.remove(key);
                }
            }
            res.add(row);
        }
        return res;
    }
}