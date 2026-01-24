class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

         // store index of each number in nums2
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int nextGreater = -1;
            
            if (map.containsKey(nums1[i])) {
                for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                    if (nums1[i] < nums2[j]) {
                        nextGreater = nums2[j];
                        break;
                    }
                }
            }

            // Always add one result per nums1 element
            res.add(nextGreater);
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;

    }
}