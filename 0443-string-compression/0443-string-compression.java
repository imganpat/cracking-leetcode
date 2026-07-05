class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;

        while (right < chars.length) {
            int count = 0;

            while (right < chars.length && chars[left] == chars[right]) {
                count++;
                right++;
            }

            sb.append(chars[left]);

            if (count > 1) {
                sb.append(count);
            }
            
            left = right;
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        

        return sb.length();
    }
}