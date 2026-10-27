class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1.0 / x;

        var result = myPow(x, n / 2);
        result *= result;
        var odd = n % 2;
        if (odd == 1) result *= x;
        if (odd == -1) result /= x;

        return result;
    }
}
