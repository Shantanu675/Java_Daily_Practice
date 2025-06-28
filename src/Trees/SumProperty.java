package Trees;

public class SumProperty {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(35);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(2);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        sumProperty(root);
        System.out.println(root.val);
        System.out.println(n1.val +" "+ n2.val +" "+ n3.val +" "+ n4.val+" "+ n5.val+" " +n6.val);
    }

    private static void sumProperty(TreeNode root) {
        if(root == null) return;
        int child = 0;
        if(root.left != null){
            child += root.left.val;
        }
        if(root.right != null){
            child += root.right.val;
        }

        if(child >= root.val) root.val = child;
        else {
            if(root.left != null) root.left.val = root.val;
            else if (root.right != null) root.right.val = root.val;
        }

        sumProperty(root.left);
        sumProperty(root.right);

        int total = 0;
        if (root.left != null) total += root.left.val;
        if (root.right != null) total += root.right.val;
        if (root.left != null || root.right != null) root.val = total;
    }
}
