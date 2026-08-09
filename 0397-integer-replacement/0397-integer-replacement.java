class Solution {
    public int integerReplacement(int n) {
        int operations = 0;
        long num = n;

        while (num > 1) {
            if (num % 2 ==  0) {
                num /= 2;
            } else {
                if (num == 3 || num % 4 == 1) {
                    num--;
                } else  {
                    num++;
                }
            }

            operations++;
        }

        return operations;
    }
}