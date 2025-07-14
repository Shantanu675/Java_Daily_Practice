package Trees;

import java.util.Stack;

class Iterator2{
    private Stack<TreeNode> st = new Stack<>();

    Iterator2(TreeNode root) {
        pushAll(root);
    }

    public boolean hasNext() {
        return st.empty();
    }

    public TreeNode next() throws NullPointerException{
        if(st.empty()) {
            throw new NullPointerException("null");
        }
        TreeNode node = st.pop();
        if(node.left != null){
            pushAll(node.left);
        }
        return node;
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.right;
        }
    }
}

public class BSTIterator2 {
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

        try {
            Iterator2 obj = new Iterator2(root);
            System.out.println(obj.next().val);
            System.out.println(obj.next().val);
            System.out.println(obj.hasNext());
            System.out.println(obj.next().val);
            System.out.println(obj.next().val);
            System.out.println(obj.next().val);
            System.out.println(obj.hasNext());
            System.out.println(obj.next().val);
            System.out.println(obj.next().val);
            System.out.println(obj.next().val);
            System.out.println(obj.next().val);
            System.out.println(obj.hasNext());
            System.out.println(obj.next().val);
            System.out.println(obj.hasNext());
            System.out.println(obj.next().val);
            System.out.println(obj.next().val);
            System.out.println(obj.hasNext());
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
