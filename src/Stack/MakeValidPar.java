package Stack;

import java.sql.SQLOutput;
import java.util.Stack;

public class MakeValidPar {
    public static void main(String[] args) {
        String str = "(()";
        System.out.println(minNum(str));
    }

    private static int minNum(String str) {
        int num = 0;
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if (ch == ')') {
                if(!stack.empty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
            else {
                stack.push(ch);
            }
        }

        while(!stack.empty()){
            stack.pop();
            num++;
        }
        return num;
    }
}
