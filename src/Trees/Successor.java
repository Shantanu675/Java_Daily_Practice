package Trees;

public class Successor {
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
        System.out.println(findSuccessor(root, n8));
    }

    private static TreeNode findSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;

        while (root != null) {
            if(p.val >= root.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
}
