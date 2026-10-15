class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            Set<Integer> unique = new HashSet<>();
            
            for (int j = i; j < n; j++) {
                unique.add(nums.get(j));

                int uniqueSize = unique.size();

                sum += uniqueSize * uniqueSize;
            }
        }

        return sum;
    }
}