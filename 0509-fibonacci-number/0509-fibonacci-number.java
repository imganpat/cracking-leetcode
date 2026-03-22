class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        
        int a = 0, b = 1;
        int c = 0;
        int count = 0;

        while(count < n - 1) {
            c = a+b;
            a = b;
            b = c;
            count++;
        }
        
        return c;
    }
}