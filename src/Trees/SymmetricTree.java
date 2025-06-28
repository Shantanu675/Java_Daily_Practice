package Trees;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(10);
        TreeNode n8 = new TreeNode(10);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n7;
        n2.left = n6;
        n2.right = n8;
        n3.right = n4;
        n4.right = n5;
        System.out.println(isSymmetric(root));

        TreeNode r = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(4);
        r.left = a1;
        r.right = a2;
        a1.left = a3;
        a1.right = a5;
        a2.left = a6;
        a2.right = a4;
        System.out.println(isSymmetric(r));

        TreeNode toor = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        toor.left = t1;
        toor.right = t2;
        t1.right = t3;
        t2.left = t4;
        System.out.println(isSymmetric(toor));
    }

    private static boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val) {
            return false;
        }

        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}
