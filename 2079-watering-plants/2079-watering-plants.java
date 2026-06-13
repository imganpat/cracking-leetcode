class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int count = 0;
        int t = capacity;

        for (int i = 0; i < plants.length; i++) {
            if (plants[i] > t) {
                count += i * 2;
                t = capacity;
            }

            count++;
            t -= plants[i];
        }

        return count;
    }
}