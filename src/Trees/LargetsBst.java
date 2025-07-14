package Trees;

class NodeVal {
    public int size;
    public int min;
    public int max;

    NodeVal (int size, int min, int max){
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

public class LargetsBst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode n1 = new TreeNode(15);
        TreeNode n2 = new TreeNode(40);
        TreeNode n3 = new TreeNode(14);
        TreeNode n4 = new TreeNode(18);
        TreeNode n5 = new TreeNode(30);
        TreeNode n6 = new TreeNode(60);
        TreeNode n7 = new TreeNode(17);
        TreeNode n8 = new TreeNode(16);
        TreeNode n9 = new TreeNode(19);
        TreeNode n10 = new TreeNode(50);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n6.left = n10;

        System.out.println(largestBST(root));
    }

    private static int largestBST(TreeNode root) {
        return largestBSTHelp(root).size;
    }

    private static NodeVal largestBSTHelp(TreeNode root) {
        if (root == null) {
            return new NodeVal(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeVal left = largestBSTHelp(root.left);
        NodeVal right = largestBSTHelp(root.right);

        if (left.max < root.val && root.val < right.min) {
            return new NodeVal(left.size + right.size + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
        }
        return new NodeVal(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
