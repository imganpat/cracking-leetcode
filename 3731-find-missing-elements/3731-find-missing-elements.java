class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int num: nums) {
            set.add(num);
            start = Math.min(num, start);
            end = Math.max(num, end);
        }

        for (int i = start; i < end; i++) {
            if (!set.contains(i)) {
                missing.add(i);
            }
        }

        return missing;
    }
}