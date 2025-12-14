class Solution {
    public String reverseVowels(String s) {
        StringBuilder res = new StringBuilder(s);
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (!isVowel(s.charAt(left))) {
                left++;
            } else if (!isVowel(s.charAt(right))) {
                right--;
            } else {
                char temp = res.charAt(left);
                res.setCharAt(left, s.charAt(right));
                res.setCharAt(right, temp);
                left++;
                right--;
            }
        }
        
        return res.toString();
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);

        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                ? true
                : false;
    }
}