class BrowserHistory {
    int current;
    List<String> history;

    public BrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        this.history.add(homepage);
        this.current = 0;
    }

    public void visit(String url) {
        for (int i = this.history.size() - 1; i > current; i--) {
            this.history.remove(i);
        }
        this.history.add(url);
        current++;
    }

    public String back(int steps) {
        // for (int i = 0; current > 0 && i < steps; i++) {
        //     current--;
        // }
        current = Math.max(current - steps, 0);
        return this.history.get(current);
    }

    public String forward(int steps) {
        // for (int i = 0; current < this.history.size() - 1 && i < steps; i++) {
        //     current++;
        // }
        current = Math.min(current + steps, history.size() - 1);
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