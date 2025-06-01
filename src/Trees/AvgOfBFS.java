package Trees;

import java.util.ArrayList;
import java.util.List;

public class AvgOfBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(3);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(3);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(3);
        l3.add(1);
        l3.add(9);
        list.add(l1);
        list.add(l2);
        list.add(l3);

        List<Double> res = getAvg(list);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<Double> getAvg(ArrayList<ArrayList<Integer>> list){
        ArrayList<Double> ans = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            double sum = 0;
            int j = 0;
            while (j < list.get(i).size()) {
                sum += (int)list.get(i).get(j);
                j++;
            }
            ans.add(sum/j);
        }
        return ans;
    }
}