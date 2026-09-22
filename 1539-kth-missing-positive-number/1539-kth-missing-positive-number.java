class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> missingNos = new ArrayList<>();
        int index = 0;
        int i = 1;

        while (missingNos.size() < k) {
            if (index < arr.length && arr[index] == i) {
                index++;
            } else {
                missingNos.add(i);
            }
            i++;
        }

        return missingNos.get(k - 1);
    }
}