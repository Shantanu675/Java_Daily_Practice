package Trees;

public class MaxHeight {
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

        System.out.println(maxHeight(root));
    }

    private static int maxHeight(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lh = 1 + maxHeight(root.left);
        int lr = 1 + maxHeight(root.right);

        return Math.max(lh, lr);
    }
}
