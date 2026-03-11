class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        int max1 = maxHeap.poll();
        int max2 = maxHeap.poll();
        
        return (max1 - 1) * (max2 - 1);
    }
}