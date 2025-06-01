package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String str = "({})";
        System.out.println(isvalid(str));
    }

    private static boolean isvalid(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if (ch == ')') {
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}