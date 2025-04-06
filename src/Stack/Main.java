package Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack(5);
        stack.push(12);
        stack.push(10);
        stack.push(15);
        stack.push(22);
        stack.push(92);
        //stack.push(02);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop());

        DynamicStack st = new DynamicStack();
        st.push(12);
        st.push(10);
        st.push(15);
        st.push(22);
        st.push(92);
        st.push(02);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
