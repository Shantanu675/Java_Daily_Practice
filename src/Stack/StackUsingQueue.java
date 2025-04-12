package Stack;

import java.util.Stack;

class StackUsingQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public StackUsingQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while(!stack1.empty()){
            int temp = stack1.pop();
            stack2.push(temp);
        }

        int poped = stack2.pop();

        while(!stack2.empty()){
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return poped;
    }

    public int peek() {
        while(!stack1.empty()){
            int temp = stack1.pop();
            stack2.push(temp);
        }

        int peeked = stack2.peek();

        while(!stack2.empty()){
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return peeked;
    }

    public boolean empty() {
        return stack1.empty();
    }
}
