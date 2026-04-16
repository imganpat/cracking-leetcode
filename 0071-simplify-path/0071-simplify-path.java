// Approach: Stack (Simulate File System Navigation)
// 1. Split the path by "/" to get directory tokens.
// 2. Use a stack to process directories:
//    - Ignore "" and "." (current directory).
//    - If ".." → go up one directory → pop from stack (if not empty).
//    - Otherwise → push valid directory name to stack.
// 3. After processing all tokens:
//    - If stack is empty → return "/".
//    - Otherwise → build path by joining stack elements with "/".
// 4. Since stack stores in reverse order, reconstruct path carefully.
//
// Time complexity: O(n)
//   - Each directory token processed once
// Space complexity: O(n)
//   - Stack + result storage

class Solution {
    public String simplifyPath(String path) {

        String[] directories = path.split("/");

        Deque<String> stack = new ArrayDeque<>();

        for (String dir : directories) {

            // Ignore empty and current directory
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }

            // Go to parent directory
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory → push
                stack.push(dir);
            }
        }

        // If nothing left → root
        if (stack.isEmpty()) {
            return "/";
        }

        // Reconstruct path
        String[] finalDirs = new String[stack.size()];
        for (int i = finalDirs.length - 1; i >= 0; i--) {
            finalDirs[i] = stack.pop();
        }

        StringBuilder res = new StringBuilder();
        for (String dir : finalDirs) {
            res.append("/").append(dir);
        }

        return res.toString();
    }
}