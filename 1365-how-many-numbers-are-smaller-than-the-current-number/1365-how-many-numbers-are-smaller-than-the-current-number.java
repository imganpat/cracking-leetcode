class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        
        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            res[i] = nums[i];
        }
        Arrays.sort(res);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(res[i])){
                map.put(res[i], i);
            }
        }

        // using the sorted array only to store the result
        for(int i = 0; i < n; i++){
            res[i] = map.get(nums[i]);
        }

        return res;
    }
}