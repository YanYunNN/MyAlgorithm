package medium;

public class Q043_AtioII_multiply {

    /**
     * * 优化的竖式计算
     * * https://leetcode.cn/problems/multiply-strings/solutions/188815/gao-pin-mian-shi-xi-lie-zi-fu-chuan-cheng-fa-by-la/
     * *      1 2 3
     * *        4 5
     * * ---------->
     * *        1 5
     * *      1 0
     * *    0 5
     * *      1 2
     * *    0 8
     * *  0 4
     * * ----------> res[5]
     * *  0 5 5 3 5
     * *
     * * 进位：  res[i + j +1]
     * * 当前位：res[i + j ]
     * * 比如 2*4 =08  i=1,j=0 8=res[2] 0=res[1]
     **/
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + n1 * n2;
                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue; //去除前导0;
            result.append(res[i]);
        }
        return result.toString();
    }


    /**
     * 朴素思想的相乘会溢出，不能AC
     */
    public String multiply1(String num1, String num2) {
        return String.valueOf(myAtoi(num1) * myAtoi(num2));
    }

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] array = s.toCharArray();
        int index = 0, n = array.length, sign = 1, res = 0;
        // 处理前置空格
        while (index < n && array[index] == ' ') {
            index++;
        }
        // index给一位处理符号
        if (index < n && (array[index] == '+' || array[index] == '-')) {
            sign = array[index++] == '+' ? 1 : -1;
        }
        //
        while (index < n && Character.isDigit(array[index])) {
            int digit = array[index] - '0';
            // 判断是否溢出
            // res*10 + digit > Integer.MAX_VALUE
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            ++index;
        }
        return sign * res;
    }
}
