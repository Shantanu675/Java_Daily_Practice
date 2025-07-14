package Trees;

public class SearchInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(12);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(10);
        TreeNode n7 = new TreeNode(14);
        TreeNode n8 = new TreeNode(13);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n6;
        n2.right = n7;
        n4.left = n5;
        n7.left = n8;
        System.out.println(search(root, 10));
    }

    private static TreeNode search(TreeNode root, int val){
        TreeNode node = root;
        while(node != null){
            if(node.val == val) {
                return node;
            }
            else if (val > node.val) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
        return new TreeNode();
    }
}