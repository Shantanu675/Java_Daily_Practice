package Trees;

import java.util.*;

class Tuple{
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(10);
        TreeNode n8 = new TreeNode(10);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n7;
        n2.left = n6;
        n2.right = n8;
        n3.right = n4;
        n4.right = n5;
        System.out.println(Arrays.toString(verticalTraversal(root).toArray()));
    }

    private static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while (! q.isEmpty()){
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            if(! map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }
            if(! map.get(col).containsKey(row)){
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, row+1, col-1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, row+1, col+1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> it: map.values()) {
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> sp: it.values()){
                while (!sp.isEmpty()){
                    result.get(result.size()-1).add(sp.poll());
                }
            }
        }
        return result;
    }
}
