class Solution {
    int count = 0;
    
    public void backtrack(int pos, int n, boolean[] used) {
        if (pos > n) {
            count++;
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (!used[num] && (pos % num == 0 || num % pos == 0)) {
                used[num] = true;
                backtrack(pos + 1, n, used);
                used[num] = false;
            }
        }
    }

    public int countArrangement(int n) {
        backtrack(1, n, new boolean[n + 1]);
        return count;       
    }
}