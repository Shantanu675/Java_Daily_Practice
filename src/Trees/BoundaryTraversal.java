package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
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
        System.out.println(Arrays.toString(boundaryTraverse(root).toArray()));
    }

    private static List<Integer> boundaryTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        leftBoundry(root.left, result);

        printLeaves(root.left, result);
        printLeaves(root.right, result);

        rightBoundry(root.right, result);
        return result;
    }

    private static void leftBoundry(TreeNode node, List<Integer> result) {
        while (node != null){
            if(! isLeaf(node)) {
                result.add(node.val);
            }
            if(node.left != null){
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private static void printLeaves(TreeNode node, List<Integer> result) {
        if(node == null){
            return;
        }

        printLeaves(node.left, result);
        if(isLeaf(node)){
            result.add(node.val);
        }
        printLeaves(node.right, result);
    }

    private static void rightBoundry(TreeNode node, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();

        while(node != null){
            if(! isLeaf(node)) {
                stack.push(node.val);
            }

            if(node.right != null){
                node = node.right;
            } else {
                node = node.left;
            }
        }

        while (! stack.empty()){
            result.add(stack.pop());
        }
    }

    private static boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }
}
