package easy;

public class Q070_jumpFloor_np {

    //青蛙一次可以跳上1级台阶，也可以跳上2级。求青蛙跳上一个n级的台阶总共有多少种跳法。
    public int jump(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //青蛙一次可以跳上1级台阶，也可以跳上2级,也可以不跳……它也可以跳上n级台阶。求青蛙跳上一个n级的台阶总共有多少种跳法。
    //dp[0]=1,dp[1]=1,dp[2]=2;
    //dp[n]=dp[n-1]+dp[n-2]+dp[n-3]+...+dp[1]+dp[0]
    //dp[n-1]=dp[n-2]+dp[n-3]+...+dp[1]+dp[0]
    //因此 dp[n]=2dp[n-1]
    public int jumpII(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0; //赋初值
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]; //dp[n]=dp[n-1]+dp[n-2]+dp[n-3]+...+dp[1]+dp[0]
            }
        }
        return dp[n];
    }

    public int jumpII_1(int n) {
        return (int) Math.pow(2, n - 1);
    }
}
