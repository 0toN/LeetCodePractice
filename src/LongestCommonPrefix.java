/**
 * 缺少思路
 * 14.最长公共前缀：编写一个函数来查找字符串数组中最长的公共前缀字符串。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{"aa", "aab", "aaac", "ad", "dddddd"});
        System.out.println("str: " + s);
    }


    //myself code
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minlen = strs[0].length();
        int shortestStrIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            int temp = strs[i].length();
            if (temp < minlen) {
                minlen = temp;
                shortestStrIndex = i;
            }
        }
        while (minlen >= 1) {
            String result = strs[shortestStrIndex].substring(0, minlen);
            int temp = minlen;
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].substring(0, minlen).equals(result)) {
                    minlen--;
                    break;
                }
            }
            if (temp == minlen) {
                return result;
            }
        }
        return "";
    }

    public String longestCommonPrefix_other(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        int minLen = 0x7fffffff;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        for (int j = 0; j < minLen; ++j) {
            for (int i = 1; i < len; ++i) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}
