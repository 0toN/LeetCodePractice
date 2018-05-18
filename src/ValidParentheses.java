import java.util.*;

/**
 * 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 括号必须以正确的顺序关闭，"([])" 和 "()[]{}" 是有效的但是 "(]" 和 "([)]" 不是。
 *
 * 没想到用栈来解决，缺少思路
 */
public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = new ValidParentheses().isValid("(()");
        System.out.println(valid);
    }


    // (:40  ):41   [:91   ]:93   {:123    }:125
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(' ');   //避免栈的判空操作
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && stack.pop() != '(') {
                return false;
            } else if (c == ']' && stack.pop() != '[') {
                return false;
            } else if (c == '}' &&  stack.pop() != '{') {
                return false;
            }
        }
        return stack.size() == 1;
    }

    //用数组模拟栈的操作使其操作更快
    public boolean isValid_1(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }

}
