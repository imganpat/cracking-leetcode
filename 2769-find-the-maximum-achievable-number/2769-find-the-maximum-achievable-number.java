class Solution {
    public int theMaximumAchievableX(int num, int t) {
        int x = num;

        for (int i = 0; i < t; i++) {
            x += 2;
        }

        return x;
    }
}