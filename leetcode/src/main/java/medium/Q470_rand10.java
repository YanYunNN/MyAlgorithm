package medium;

import java.util.Random;

/**
 * @author: xcai
 * @date: 2024/06/04
 * @see <a href='https://leetcode.cn/problems/implement-rand10-using-rand7/solutions/167850/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-'>Conf<a/>
 */
public class Q470_rand10 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     * ** (rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
     */
    public int rand10() {
        while (true) {
            int rand49 = (rand7() - 1) * 7 + rand7();
            if (rand49 <= 40) return rand49 % 10 + 1; //0-9+1
        }
    }

    /***
     * rand9()          : {1, 2, 3, 4, 5, 6, 7, 8, 9}
     * rand9()-1        : {0, 1, 2, 3, 4, 5, 6, 7, 8}  // rand() 随机数列 + 一个常数，不会改变随机概率
     * [rand9()-1] * 7  : {0, 7, 14, 21, 28, 35, 42, 49, 56}  // 这里就可以看出端倪了，前半部分数字间的间隔刚好就为7
     * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
     * 令前半部分[rand9()-1] * 7 为 A，后半部分rand7() 为 B
     *
     *  A\B | 1 | 2 | 3 | 4 | 5 | 6 | 7
     * ---------------------------------------
     *  0   | 1 | 2 | 3 | 4 | 5 | 6 | 7
     *  7   | 8 | 9 | 10| 11| 12| 13| 14
     *  14  | .... 懒得打了
     *  21  | ....
     *  28  |
     *  35  |
     *  42  |
     *  49  |
     *  56  |
     * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
     ** @return int
     **/
    private int rand7() {
        return new Random().nextInt(7);
    }

}
