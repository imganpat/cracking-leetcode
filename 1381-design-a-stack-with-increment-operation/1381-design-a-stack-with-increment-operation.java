class CustomStack {
    int[] stack; 
    int top = -1; 

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
    }

    public void push(int x) {
        // stack overflow check
        if (this.top >= this.stack.length - 1) {
            return;
        }
        this.top++;
        this.stack[this.top] = x;
    }

    public int pop() {
        // empty stack check
        if (this.top < 0) {
            return -1;
        }
        int x = this.stack[this.top];
        this.top--;
        return x;
    }

    public void increment(int k, int val) {
        // increment only existing elements
        int limit = Math.min(k, this.top + 1);
        for (int i = 0; i < limit; i++) {
            this.stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */