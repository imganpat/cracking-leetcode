class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0, end = 0;
        Map<Integer, Integer> trees = new HashMap<>();
        int max = 0;

        while (end < fruits.length) {
            trees.put(fruits[end], trees.getOrDefault(fruits[end], 0) + 1);
            while (trees.size() > 2) {
                trees.put(fruits[start], trees.get(fruits[start]) - 1);
                if (trees.get(fruits[start]) == 0) {
                    trees.remove(fruits[start]);
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}