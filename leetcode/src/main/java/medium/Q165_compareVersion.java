package medium;

public class Q165_compareVersion {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            int a = 0, b = 0; //赋初值+补0
            if (i < v1.length) a = Integer.parseInt(v1[i++]);
            if (j < v2.length) b = Integer.parseInt(v2[j++]);

            //从头开始比较
            if (a != b) return a > b ? 1 : -1;
        }
        return 0;
    }
}
