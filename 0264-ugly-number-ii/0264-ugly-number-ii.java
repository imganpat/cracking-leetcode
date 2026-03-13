class Solution {
    public int nthUglyNumber(int n) {
        int [] uglyNums = new int[n];
        uglyNums[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;

        for(int i = 1; i < n; i++){
            int next2 = uglyNums[i2] * 2;
            int next3 = uglyNums[i3] * 3;
            int next5 = uglyNums[i5] * 5;

            int next = Math.min(next2, Math.min(next3, next5));

            uglyNums[i] = next;

            if(next == next2){
                i2++;
            }

            if(next == next3){
                i3++;
            }

            if(next == next5){
                i5++;
            }
        }

        return uglyNums[n - 1];

    }
}