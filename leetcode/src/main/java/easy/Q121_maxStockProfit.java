package easy;

public class Q121_maxStockProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; //假设i天卖出，找局部最低点
            } else if (prices[i] - minPrice > max) {
                max = prices[i] - minPrice;
            }
        }
        return max;

    }

    public int maxProfit1(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            max = Math.max(price - minPrice, max);
        }
        return max;
    }
}
