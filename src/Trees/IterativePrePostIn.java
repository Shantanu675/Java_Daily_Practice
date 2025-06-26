package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}

public class IterativePrePostIn {
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

        System.out.println(Arrays.toString(preorder(root).toArray()));
        System.out.println(Arrays.toString(inorder(root).toArray()));
        System.out.println(Arrays.toString(postorder(root).toArray()));
    }

    //with single stack
    private static List<Integer> preorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (! stack.empty()){
            TreeNode current = stack.pop();
            list.add(current.val);

            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }
        return list;
    }

    //with single stack
    private static List<Integer> inorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.empty()){
                    break;
                }
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    //with two stack
    private static List<Integer> postorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode node = root;

        while (! stack1.empty()){
            node = stack1.pop();
            stack2.push(node);
            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }

        while (! stack2.empty()){
            list.add(stack2.pop().val);
        }
        return list;
    }
}
