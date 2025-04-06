package Queue;

public class DynamicQueue extends CircularQueue{
    DynamicQueue(){
        super();
    }

    DynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item){
        if(this.isFull()){
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                data[i-1] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}
