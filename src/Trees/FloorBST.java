package Trees;

public class FloorBST {
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
        System.out.println(floor(root, 9));
    }

    private static int floor (TreeNode root, int val){
        int floorNode = -1;
        TreeNode node = root;

        while (node != null){
            if(node.val == val){
                return node.val;
            }

            if(node.val > val) {
                node = node.left;
            }
            else {
                floorNode = node.val;
                node = node.right;
            }
        }
        return floorNode;
    }
}
