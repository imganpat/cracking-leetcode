class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (char c : word.toCharArray()) {
                sum += weights[c - 'a'];
            }

            int remainder = sum % 26;
            char mappedChar = (char) ('z' - remainder);

            res.append(mappedChar);
        }

        return res.toString();
    }
}
