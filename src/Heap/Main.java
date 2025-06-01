package Heap;

public class Main {
    public static void main(String[] args) throws Exception {
        HeapEx<Integer> heap = new HeapEx<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(98);
        heap.insert(43);
        heap.insert(54);
        heap.insert(89);

        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());

        System.out.println(heap.heapSort());
    }
}
