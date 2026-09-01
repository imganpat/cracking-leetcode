class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] t = arr.clone();

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int num: arr) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        int[] ranks = new int[n]; 

        for (int i = 0; i < n; i++) {
            ranks[i] = map.get(t[i]);
        }

        return ranks;
    }
}