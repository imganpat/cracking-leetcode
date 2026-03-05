class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for(i = 0; i < k; i++){
            pq.add(nums[i]);
        }

        while(i < nums.length){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }

        return pq.poll();
    }
}