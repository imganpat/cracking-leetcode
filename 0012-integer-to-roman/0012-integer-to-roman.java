class Solution {
    public String intToRoman(int num) {
        String[] symbols = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int[] values = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

        StringBuilder roman = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i--) {
            if(num == 0){
                break;
            }
            while(num >= values[i]){
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
}