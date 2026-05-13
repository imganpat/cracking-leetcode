import java.math.BigInteger;

class Solution {

    public BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n)
                .multiply(factorial(n - 1));
    }

    public int numTrees(int n) {

        BigInteger factorialOf2N = factorial(2 * n);
        BigInteger factorialOfNPlus1 = factorial(n + 1);
        BigInteger factorialOfN = factorial(n);

        BigInteger ans = factorialOf2N.divide(
                factorialOfNPlus1.multiply(factorialOfN)
        );

        return ans.intValue();
    }
}