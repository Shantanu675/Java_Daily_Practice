package Trees;

public class NodeComplete {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(9);
        TreeNode n9 = new TreeNode(10);
        TreeNode n10 = new TreeNode(11);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n3.left = n7;
        n3.right = n8;
        n4.left = n9;
        n4.right = n10;
        System.out.println(numberOfNode(root));
    }

    private static int numberOfNode(TreeNode root) {
        if(root == null) return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if(lh == rh) {
            return (int) Math.pow(2, rh) - 1;
        }

        else {
            return numberOfNode(root.left) + numberOfNode(root.right) + 1;
        }
    }

    private static int leftHeight(TreeNode node) {
        int count = 0;
        while(node != null){
            count++;
            node = node.left;
        }
        return count;
    }

    private static int rightHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return rightHeight(node.right);
    }
}
