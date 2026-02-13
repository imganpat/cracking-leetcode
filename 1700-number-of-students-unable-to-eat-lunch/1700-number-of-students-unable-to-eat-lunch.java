class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int res = sandwiches.length;

        int[] map = new int[2];
        for (int i : students) {
            if (i == 0) {
                map[0]++;
            } else {
                map[1]++;
            }
        }

        for (int i : sandwiches) {
            if (map[i] > 0) {
                map[i]--;
                res--;
            } else {
                return res;
            }
        }
        return res;
    }
}