package Trees; // leftView, rightView, topView, bottomView

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRightView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.left = n1;
        root.right = n6;
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(Arrays.toString(leftView(root).toArray()));
        System.out.println(Arrays.toString(rightView(root).toArray()));
    }

    private static List<Integer> rightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rView(root, list, 0);
        return list;
    }

    private static void rView(TreeNode root, List<Integer> list, int level) {
        if(root == null){
            return;
        }

        if(list.size() == level){
            list.add(root.val);
        }

        rView(root.right, list, level+1);
        rView(root.left, list, level+1);
    }

    private static List<Integer> leftView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        lView(root, list, 0);
        return list;
    }

    private static void lView(TreeNode root, List<Integer> list, int level) {
        if(root == null){
            return;
        }

        if (list.size() == level){
            list.add(root.val);
        }

        lView(root.left, list, level+1);
        lView(root.right, list, level+1);
    }
}
