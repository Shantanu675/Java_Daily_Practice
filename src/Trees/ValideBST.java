package Trees;

public class ValideBST {
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
        System.out.println(isValid(root));
    }

    private static boolean isValid(TreeNode root) {
        return valid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean valid(TreeNode node, int leftbound, int rightBound) {
        if (node == null) {
            return true;
        }

        if (node.val > leftbound || node.val < rightBound) {
            return false;
        }

        return valid(node.left, node.val, rightBound) && valid(node.right, leftbound, node.val);
    }
}
