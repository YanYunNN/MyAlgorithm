package medium;

public class Q008_Atio_str2num {
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
