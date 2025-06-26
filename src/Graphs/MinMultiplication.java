package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class T{
    int step;
    int num;

    T(int step, int num){
        this.step = step;
        this.num = num;
    }
}

public class MinMultiplication {
    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        int s = 7;
        int e = 66175;
        System.out.println(minSteps(arr, s, e));
    }

    private static int minSteps(int[] arr, int start, int end) {
        Queue<T> q = new LinkedList<>();
        q.offer(new T(0, start));

        int[] dist = new int[100000];
        for (int i = 0; i < 100000; i++) {
            dist[i] = (int)1e9;
        }
        dist[start] = 0;
        int mod = 100000;

        while (!q.isEmpty()){
            T curr = q.poll();
            int num = curr.num;
            int step = curr.step;

            for (int it : arr) {
                int n = (it * num) % mod;
                if(step + 1 < dist[n]) {
                    dist[n] = step + 1;
                    if (n == end) return step + 1;
                    q.offer(new T(dist[n], n));
                }
            }
        }
        return -1;
    }
}
