package Stack;

import java.util.Stack;

public class InBuildExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack <Integer> st = new Stack<>();
        stack.push(12);
//        stack.push(10);
//        stack.push(15);
//        stack.push(22);
        for (int i = 0; i < 10; i++) {
            stack.push(i*2);
        }
        System.out.println(stack.elements());
        System.out.println(stack);
        stack.push(10);
        stack.push(18);
        stack.push(18);
    }
}
