package Stack;

//Non Dynamic

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;
    CustomStack(){
        this(DEFAULT_SIZE);
    }

    CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push (int item){
        if(isFull()){
            System.out.println("Stack is full!!!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is already Empty!!!");
        }
        int curr = data[ptr];
        ptr--;
        return curr;
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is already Empty!!!");
        }
        return data[ptr];
    }

    public boolean isFull(){
        return ptr == DEFAULT_SIZE-1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }
}
