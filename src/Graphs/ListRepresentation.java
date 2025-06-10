package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRepresentation {
    public static void main(String[] args) {
        int n = 3, m = 3;
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<Integer>());
        }

        //1->2
        list.get(1).add(2);
        list.get(2).add(1);

        //2->3
        list.get(2).add(3);
        list.get(3).add(2);

        //1->3
        list.get(1).add(3);
        list.get(3).add(1);

        System.out.println(Arrays.toString(list.stream().toArray()));
    }
}
