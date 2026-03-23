class Solution {
    public boolean isEven(int n, int[] freq) {
        int[] temp = new int[10];

        if ((n % 10) % 2 != 0)
            return false;

        while (n > 0) {
            int d = n % 10;
            temp[d]++;
            if (temp[d] > freq[d]) {
                return false;
            }
            n /= 10;
        }

        return true;
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        List<Integer> l = new ArrayList<>();
        for (int i = 100; i < 1000; i++) {
            if (isEven(i, freq)) {
                l.add(i);
            }
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }

        return res;
    }
}