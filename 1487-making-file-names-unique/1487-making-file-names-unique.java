class Solution {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        Map<String, Integer> unique = new HashMap<>();
        String[] res = new String[names.length];

        for (int i = 0; i < n; i++) {
            String name = names[i];

            if (!unique.containsKey(name)) {
                res[i] = name;
                unique.put(name, 1);

            } else {
                int k = unique.get(name);
                while (unique.containsKey(name + "(" + k + ")")) {
                    k++;
                }

                String newName = name + "(" + k + ")";

                res[i] = newName;
                unique.put(name, k + 1);
                unique.put(newName, 1);
            }
        }

        return res;
    }
}