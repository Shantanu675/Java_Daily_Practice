package Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tuples{
    TreeNode node;
    int num;

    public Tuples(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}

public class Width {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode n1 = new TreeNode(2);
//        TreeNode n2 = new TreeNode(3);
//        TreeNode n3 = new TreeNode(4);
//        TreeNode n4 = new TreeNode(5);
//        TreeNode n5 = new TreeNode(6);
//        TreeNode n6 = new TreeNode(7);
//        root.left =n1;
//        root.right =n6;
//        n1.left =n2;
//        n1.right =n3;
//        n3.left =n4;
//        n3.right =n5;

//        System.out.println(findWidth(root));

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
        System.out.println(findWidth(root));
    }

    private static int findWidth(TreeNode root){
        if(root == null){
            return -1;
        }
        int width = 0;
        Queue<Tuples> q = new LinkedList<>();
        q.offer(new Tuples(root, 0));

        while (! q.isEmpty()){
            int qSize = q.size();
            int min = q.peek().num;
            int first = Integer.MAX_VALUE;
            int last = Integer.MIN_VALUE;

            for (int i = 0; i < qSize; i++) {
                Tuples curr = q.poll();
                TreeNode node = curr.node;
                int k = curr.num-first;

                if(i == 0){
                    first = curr.num;;
                }
                if(i == qSize-1){
                    last = curr.num;
                }

                if(node.left != null){
                    q.offer(new Tuples(node.left, 2*k+1));
                }
                if(node.right != null){
                    q.offer(new Tuples(node.right, 2*k+2));
                }
            }
            width = Math.max((last - first + 1), width);
        }
        return width;
    }
}
