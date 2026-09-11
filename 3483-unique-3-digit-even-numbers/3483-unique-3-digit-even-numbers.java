class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j  < digits.length; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < digits.length; k++) {
                    if (k  == i || k == j) {
                        continue;
                    }

                    int  num = digits[i] * 100 + digits[j] *  10 +  digits[k];

                    if (!set.contains(num) && num % 2 == 0) {
                        set.add(num);
                        count++;
                    }
                }
            }
        }

        return count;
    }
}