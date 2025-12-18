// Approach: HashMap Grouping by Size
// 1. Use a HashMap where the key is the group size and the value is a list of indices
//    of people who want to be in a group of that size.
// 2. Traverse the array `groupSizes`:
//    - For each person `i`, add their index to the list corresponding to `groupSizes[i]`.
// 3. Whenever the size of a list becomes equal to the required group size,
//    it means a complete group is formed.
//    - Add this group to the result list.
//    - Reset the list for that group size in the map to start forming a new group.
// 4. Continue this process until all people are assigned to groups.
// 5. Return the list of all formed groups.
//
// Time complexity: O(n) – each person is processed once
// Space complexity: O(n) – HashMap and result list store indices of all people

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // Map to store group size -> list of person indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        // Iterate over each person
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            // Initialize list for this group size if not present
            map.putIfAbsent(size, new ArrayList<>());

            // Add current person index to its group
            List<Integer> group = map.get(size);
            group.add(i);

            // If group reaches required size, add to result
            if (group.size() == size) {
                res.add(group);

                // Reset the group list for this size
                map.put(size, new ArrayList<>());
            }
        }

        // Return all valid groups
        return res;
    }
}
