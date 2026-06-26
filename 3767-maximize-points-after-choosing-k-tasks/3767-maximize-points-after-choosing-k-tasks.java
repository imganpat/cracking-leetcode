class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        long res = 0;
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < technique1.length; i++) {
            if (technique1[i] >= technique2[i]) {
                res += technique1[i];
                count++;
            } else{
                res += technique2[i];
                pq.offer(technique2[i] - technique1[i]);
            }   
        }

        int need = k - count;

        while (need > 0) {
            res -= pq.poll();
            need--;
        }

        return res;
    }
}