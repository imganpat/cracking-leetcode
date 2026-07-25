class Solution {
    public int maxProduct(int n) {
        List<Integer> l = new ArrayList<>();

        while (n > 0) {
            int d = n % 10;
            l.add(d);
            n /= 10;
        }

        Collections.sort(l);

        return l.get(l.size() - 1) * l.get(l.size() - 2);
    }
}