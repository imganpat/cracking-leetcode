class BrowserHistory {
    int current;
    List<String> history = new ArrayList<>();

    public BrowserHistory(String homepage) {
        this.current = 0;
        history.add(homepage);
    }
    
    public void visit(String url) {
        for(int i = history.size() - 1; i > current; i--){
            history.remove(i);
        }
        this.current++;
        history.add(current, url);
    }
    
    public String back(int steps) {
        for(int i = 0; current > 0 && i < steps; i++){
            current--;
        }
        return history.get(current);
    }
    
    public String forward(int steps) {
        for(int i = 0; current < history.size() - 1  && i < steps; i++){
            current++;
        }
        return history.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */