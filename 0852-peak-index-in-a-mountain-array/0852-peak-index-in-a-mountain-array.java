class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        int res = -1;

        while (low < high) {
            int guess = (low + high) / 2;
            if (arr[guess] < arr[guess + 1]) {
                low = guess + 1;
            } else {
                res = guess;
                high = guess;
            }
        }
        return low;
    }
}