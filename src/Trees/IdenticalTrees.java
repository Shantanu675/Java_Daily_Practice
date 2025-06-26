package Trees;

public class IdenticalTrees {
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

        TreeNode r = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(7);
        r.left = t1;
        r.right = t4;
        t1.left = t2;
        t1.right = t3;
        System.out.println(isIdentical(root, root));
        System.out.println(isIdentical(r, r));
        System.out.println(isIdentical(root, r));
    }

    private static boolean isIdentical(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return (p == q);
        }

        return p.val == q.val && isIdentical(p.right, q.right) && isIdentical(p.left, q.left);
    }
}
