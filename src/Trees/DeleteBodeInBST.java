package Trees;

public class DeleteBodeInBST {
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
        System.out.println(delete(root, 6));
    }

    private static TreeNode delete(TreeNode root, int key){
        if(root == null){
            return null;
        }

        if(root.val == key){
            return helper(root);
        }

        TreeNode node = root;
        while (node != null) {
            if(node.val > key) {
                if (node.left != null && node.left.val > key) {
                    node.left = helper(node.left);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right != null && node.right.val == key) {
                    node.right = helper(node.right);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }

    private static TreeNode helper(TreeNode node){
        if(node.right == null) {
            return node.left;
        } else if (node.left == null) {
            return node.right;
        } else {
            TreeNode rightNode = node.right;
            TreeNode extremRight = findExtremRight(node.left);
            extremRight.right = rightNode;
            return node.left;
        }
    }

    private static TreeNode findExtremRight(TreeNode root) {
        if(root.right == null) {
            return root;
        }
        return findExtremRight(root.right);
    }
}
