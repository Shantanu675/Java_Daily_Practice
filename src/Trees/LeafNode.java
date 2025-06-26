package Trees;

public class LeafNode {
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
        System.out.println(countLeaves(root));
    }

    static int counter = 0;
    private static int countLeaves(TreeNode root) {
        traverse(root);
        return counter;
    }

    private static void traverse(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            counter++;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
