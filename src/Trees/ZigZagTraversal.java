package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.left =n1;
        root.right =n6;
        n1.left =n2;
        n1.right =n3;
        n3.left =n4;
        n3.right =n5;

        TreeNode r = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(7);
        r.left =t1;
        r.right =t4;
        t1.left =t2;
        t1.right =t3;

        System.out.println(Arrays.toString(zigzag(root).toArray()));
    }

    private static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean reverse = false;//=====================

        while (! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = queue.poll();

                //=====================================
                if(reverse) {
                    list.addFirst(curr.val);
                } else {
                    list.add(curr.val);
                }
                //=====================================

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            reverse = ! reverse;//======================
            result.add(list);
        }
        return result;
    }
}
