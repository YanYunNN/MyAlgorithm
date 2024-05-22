package easy;

public class Q415_twostringsum {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int n = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + n;
            n = tmp / 10;
            sb.append(tmp % 10); //如果不想倒转，那就是res=res+(tmp%10) 累计和+余数
            i--;
            j--;
        }
        if (n == 1) sb.append("1");
        return sb.reverse().toString();
    }
}
