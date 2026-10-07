class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> per = new ArrayList<>();
        for (int i  = 1; i <= m; i++) {
            per.add(i);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i  < queries.length; i++) {
            int query = queries[i];
            int index = per.indexOf(query);

            res[i] = index;
            
            per.remove(index);
            
            per.add(0,query);
        }

        return res;
    }
}