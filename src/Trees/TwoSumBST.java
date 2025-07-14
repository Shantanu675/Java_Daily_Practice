package Trees;

import java.util.Stack;

class Help {
    private Stack<TreeNode> st1 = new Stack<>();
    private Stack<TreeNode> st2 = new Stack<>();

    Help(TreeNode root, boolean isReverse){
        pushAll(root, isReverse);
    }

    public TreeNode next() {
        TreeNode node = st1.pop();
        if(node.right != null) {
            pushAll(node.right, false);
        }
        return node;
    }

    public TreeNode before() {
        TreeNode node = st2.pop();
        if(node.left != null) {
            pushAll(node.left, true);
        }
        return node;
    }

    private void pushAll(TreeNode root, boolean isReverse) {
        while (root != null){
            if(! isReverse) {
                st1.push(root);
                root = root.left;
            } else {
                st2.push(root);
                root = root.right;
            }
        }
    }
}

public class TwoSumBST {
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
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n3.left = n7;
        n3.right = n8;
        n4.right = n9;

        System.out.println(twoSum(root, 2));
    }

    private static boolean twoSum(TreeNode root, int target) {
        TreeNode dummy = root;
        Help obj1 = new Help(root, false);
        Help obj2 = new Help(dummy, true);

        TreeNode smaller = obj1.next();
        TreeNode larger = obj2.before();

        while (smaller.val < larger.val) {
            if(smaller.val + larger.val == target) {
                return true;
            } else if (smaller.val + larger.val > target) {
                larger = obj2.before();
            } else {
                smaller = obj1.next();
            }
        }
        return false;
    }
}
