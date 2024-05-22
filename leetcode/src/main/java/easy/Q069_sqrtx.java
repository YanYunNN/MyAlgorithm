package easy;

public class Q069_sqrtx {
    public int mySqrt1(int x) {
        long ans = 0;
        for (long i = 0; i * i <= x; i++) {
            ans = i;
        }
        return (int) ans;
    }

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;  // Update ans,即使在没有找到精确平方根时，ans 也会是小于等于 x 的最大整数平方根
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
