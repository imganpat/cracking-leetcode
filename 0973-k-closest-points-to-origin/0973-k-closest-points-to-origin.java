class Solution {
    class Pair{
        int key;
        int[] values;

        Pair(int key, int[] values){
            this.key=key;
            this.values = values;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap  = new PriorityQueue<>((a,b) -> b.key - a.key);
        
        for(int[] point: points){
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;

            maxHeap.offer(new Pair(dist, new int[]{x,y}));

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i  = 0;

        while(!maxHeap.isEmpty()){
            res[i++] = maxHeap.poll().values;
        }

        return res;



    }
}