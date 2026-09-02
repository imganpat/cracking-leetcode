class Solution {
    public int countVowelStrings(int n) {
        int[] arr = new int[] {1, 1, 1, 1, 1};

        for (int t = 2; t <= n;  t++) {
            for (int i = 1;  i < 5; i++)  {
                arr[i] = arr[i] +  arr[i -1];
            }
        }

        int sum = 0;
        
        for (int num: arr) {
            sum += num;
        }

        return sum;
    }
}