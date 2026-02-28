class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums1){
            set.add(i);
        }

        Set<Integer> intersections = new HashSet<>();
        for(int i: nums2){
            if(set.contains(i)){
                intersections.add(i);
            }
        }

        int[] r = new int[intersections.size()];
        int i = 0;
        for(int e: intersections){
            r[i++] = e;
        }

        return r;
    }

}