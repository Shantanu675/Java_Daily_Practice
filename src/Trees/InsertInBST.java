package Trees;

public class InsertInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(10);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        insert(root, 8);
        System.out.println(root);
    }

    private static TreeNode insert(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        TreeNode node = root;

        while(true) {
            if(node.val <= val){
                if(node.right != null){
                    node = node.right;
                }
                else {
                    node.right = new TreeNode(val);
                    break;
                }
            }
            else {
                if(node.left != null){
                    node = node.left;
                }
                else {
                    node.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
