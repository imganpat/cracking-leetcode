// Approach: HashMap + Greedy Name Generation
// 1. Process folder names one by one.
// 2. Maintain a HashMap:
//      name -> next suffix to try
// 3. For each name:
//    Case 1: Name not used before
//      - Use it directly.
//      - Store next suffix as 1.
//
//    Case 2: Name already exists
//      - Start from the stored suffix k.
//      - Keep trying:
//            name(k)
//        until an unused name is found.
//      - Use that new name.
//      - Update:
//          • original name -> k + 1
//          • new name -> 1
// 4. Store each assigned name in the result array.
//
// Time complexity: O(n) amortized
//   - Each suffix is tried at most once overall
// Space complexity: O(n)
//   - HashMap + output array

class Solution {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        Map<String, Integer> unique = new HashMap<>();
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            String name = names[i];

            // First occurrence
            if (!unique.containsKey(name)) {
                res[i] = name;
                unique.put(name, 1);
            }

            // Duplicate name
            else {
                int k = unique.get(name);

                // Find first available suffix
                while (unique.containsKey(name + "(" + k + ")")) {
                    k++;
                }

                String newName = name + "(" + k + ")";

                res[i] = newName;
                // Next suffix to try for original name
                unique.put(name, k + 1);
                // Mark generated name as used
                unique.put(newName, 1);
            }
        }

        return res;
    }
}