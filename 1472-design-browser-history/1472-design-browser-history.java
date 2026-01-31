class BrowserHistory {
    int curInd;
    ArrayList<String> arr;

    public BrowserHistory(String homepage) {
        arr = new ArrayList<>();
        arr.add(homepage);
        curInd = 0;
    }
    
    public void visit(String url) {
        int ind = arr.size()-1;
        while(curInd < ind){
            arr.remove(ind);
            ind--;
        }
        arr.add(url);
        curInd++;
    }
    
    public String back(int steps) {
        curInd = Math.max(curInd-steps, 0);
        return arr.get(curInd);
    }
    
    public String forward(int steps) {
        curInd = Math.min(curInd+steps, arr.size()-1);
        return arr.get(curInd);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */