class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(freq.values());
        frequencies.sort(Collections.reverseOrder());

        int res = 0;

        for (int i= 0; i < frequencies.size(); i++) {
            int pushes = i / 8 + 1;
            res += pushes * frequencies.get(i);
        }

        return res;
    }
}