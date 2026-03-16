class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(i);

            while(maxHeap.peek() <= i - k) {
                maxHeap.poll();
            }
            
            if(i >= k - 1){
                res[index++] = nums[maxHeap.peek()];
            }
            
        }

        return res;
    }
}