/**
 * 9.回文数：判断一个整数是否是回文数，不能使用辅助空间。
 */
public class PalindromeNumber {

    public static void main(String args[]) {
        boolean palindrome = new PalindromeNumber().isPalindrome1(2147483647);
        System.out.println("palindrome : " + palindrome);
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x, reverse = 0;
        for (; temp > 0; temp /= 10) {
            reverse = reverse * 10 + temp % 10;
        }
        System.out.println(reverse);
        return x == reverse;
    }
}


