class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for(String dir: directories){
            if(dir.equals("") || dir.equals(".")){
                continue;
            }
            
            if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(dir);
            }
        }

        if(stack.size() == 0){
            return "/";
        }

        String[] finalDirs = new String[stack.size()];
        for(int i = finalDirs.length - 1; i >= 0; i--){
            finalDirs[i] = stack.pop();
        }
        
        StringBuilder res = new StringBuilder();
        for(String dir: finalDirs){
            res.append("/");
            res.append(dir);
        }
        return res.toString();
    }
}