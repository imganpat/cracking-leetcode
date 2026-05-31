class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        int [] leftPrefix = new int[n + 1];
        int [] rightPrefix = new int[n + 1];
        int [] upPrefix = new int[n + 1];
        int [] downPrefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            leftPrefix[i + 1] = leftPrefix[i];
            rightPrefix[i + 1] = rightPrefix[i];
            upPrefix[i + 1] = upPrefix[i];
            downPrefix[i + 1] = downPrefix[i];

            char c = s.charAt(i);
            switch (c) {
                case 'L': {
                    leftPrefix[i + 1]++;
                    break;
                } case 'R': {
                    rightPrefix[i + 1]++;
                    break;
                } case 'U': {
                    upPrefix[i + 1]++;
                    break;
                } default : {
                    downPrefix[i + 1]++;
                }
            }
        }

        Set<List<Integer>> points = new HashSet<>();
        int totalX = rightPrefix[n] - leftPrefix[n];
        int totalY = upPrefix[n] - downPrefix[n];

        for (int i = 0; i <= n - k; i++) {
            int t = i + k - 1;

            int l = leftPrefix[t + 1] - leftPrefix[i];
            int r = rightPrefix[t + 1] - rightPrefix[i];
            int u = upPrefix[t + 1] - upPrefix[i];
            int d = downPrefix[t + 1] - downPrefix[i];

            int dx = r - l;
            int dy = u - d;

            int newX = totalX - dx; 
            int newY = totalY - dy; 

            points.add(Arrays.asList(newX, newY));
        }

        return points.size();
    }
}