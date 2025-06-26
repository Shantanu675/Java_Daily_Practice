package Trees;

import java.util.*;

public class BottomView {
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
        //n4.right = n5;
        System.out.println(Arrays.toString(bottomView(root).toArray()));
    }

    private static List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> q = new LinkedList<>();
        q.add(new Pairs(root, 0));

        while (! q.isEmpty()){
            Pairs current = q.poll();
            TreeNode node = current.node;
            int line = current.line;

            map.put(line, node.val);

            if (node.left != null){
                q.offer(new Pairs(node.left, line-1));
            }
            if (node.right != null){
                q.offer(new Pairs(node.right, line+1));
            }
        }
        for(int it : map.values()){
            result.add(it);
        }
        return result;
    }
}
