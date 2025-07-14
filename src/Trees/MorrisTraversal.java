package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.right = n5;
        System.out.println(inorder(root));
        System.out.println(preorder(root));
    }

    private static List<Integer> inorder(TreeNode root){
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;

        while(cur != null){
            if(cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                }
                else {
                    prev.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return list;
    }

    private static List<Integer> preorder(TreeNode root){
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;

        while(cur != null) {
            if(cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                }
                else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}
