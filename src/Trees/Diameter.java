package Trees;

public class Diameter {
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
        System.out.println(findDiameter(root));
    }

    static int maxDiameter = 0;
    private static int findDiameter(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private static int height(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        maxDiameter = Math.max(maxDiameter, (leftHeight + rightHeight));

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
