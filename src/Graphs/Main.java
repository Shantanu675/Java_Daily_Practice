package Graphs;

import java.util.ArrayList;
import java.util.List;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for (int i = 0; i < n+1; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)) {
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        }
        else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_u, ulp_v);
        }
        else {
            parent.set(ulp_u, ulp_v);
            int rankA = rank.get(ulp_u);
            rank.set(++rankA, ulp_u);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
            int size1 = size.get(ulp_v);
            size1 += size.get(ulp_u);
            size.set(size1, ulp_v);
        }
        else {
            parent.set(ulp_u, ulp_v);
            int size1 = size.get(ulp_u);
            size1 += size.get(ulp_v);
            size.set(size1, ulp_u);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        if (ds.findParent(6) == ds.findParent(7)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }

        ds.unionByRank(3,7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
    }
}
