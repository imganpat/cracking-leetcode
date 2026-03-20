class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int[] course: courses){
            minHeap.offer(course);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        int courseTaken = 0;
        int days = 0;
        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            days += top[0];
            maxHeap.offer(top[0]);
            courseTaken++;
            
            if(days > top[1]){
                days -= maxHeap.poll();
                courseTaken--;
            }
        }

        return courseTaken;
    }
}