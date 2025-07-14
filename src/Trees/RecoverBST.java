package Trees;

import java.util.function.BinaryOperator;

public class RecoverBST {
    private static TreeNode first;
    private static TreeNode middle;
    private static TreeNode last;
    private static TreeNode prev;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(13);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(11);
        TreeNode n6 = new TreeNode(15);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(4);
        TreeNode n9 = new TreeNode(9);
        root.left = n1;
        root.right = n2;
        n1.left = n8;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n8.left = n7;
        n8.right = n3;
        n4.right = n9;
        recover(root);
        System.out.println(root);

//        root.left = n1;
//        root.right = n2;
//        n1.left = n3;
//        n1.right = n4;
//        n2.left = n5;
//        n2.right = n6;
//        n3.left = n7;
//        n3.right = n8;
//        n4.right = n9;
//        recover(root);
    }

    private static void recover(TreeNode root) {
        first = last = middle = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);
        if(first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if (first != null && middle != null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if(prev != null && prev.val > root.val) {
            // first violation
            if(first == null){
                middle = root;
                first = prev;
            }
            // second violation
            else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
