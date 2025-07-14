package Trees;

import java.util.Stack;

public class TreeToLinkedlist {
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
        //convertLL1(root);
        //System.out.println(convertLL2(root));
        System.out.println(convertLL3(root));
    }

    private static TreeNode convertLL3(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode prev = cur.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
            }
            cur = cur.right;
        }
        return root;
    }

    private static TreeNode convertLL2(TreeNode root) {
//        iterative solution
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(! st.isEmpty()) {
            TreeNode curr = st.pop();

            if(curr.right != null) {
                st.push(curr.right);
            }
            if(curr.left != null) {
                st.push(curr.left);
            }
            if(! st.isEmpty()) {
                curr.right = st.peek();
            }

            curr.left = null;
        }
        return root;
    }

    static TreeNode prev = null;
    private static void convertLL1(TreeNode node) {
        if(node == null){
            return;
        }

        convertLL1(node.right);
        convertLL1(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}
