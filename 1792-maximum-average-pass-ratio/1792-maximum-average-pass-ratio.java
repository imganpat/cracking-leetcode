class Solution {
    public double gain(int pass, int total) {
        double before = (double) pass / total;
        double after = (double) (pass + 1) / (total + 1);
        return after - before;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            double gain = gain(pass, total);

            pq.add(new double[] { gain, pass, total });
        }

        while (extraStudents > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];

            pass++;
            total++;

            double gain = gain(pass, total);

            pq.add(new double[] { gain, pass, total });

            extraStudents--;
        }

        double sum = 0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            int pass = (int) c[1];
            int total = (int) c[2];

            sum += (double) pass / total;
        }

        return sum / classes.length;
    }
}