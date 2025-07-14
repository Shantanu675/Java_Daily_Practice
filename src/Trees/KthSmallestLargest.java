package Trees;

public class KthSmallestLargest {
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
        System.out.println(kthSmall(root, 1));
        System.out.println(kthLarge(root, 6));
    }

    private static int kthLarge(TreeNode root, int k) {
        int[] ans = {-1};
        int[] count = {0};

        larger(root, k, count, ans);
        return ans[0];
    }

    private static void larger(TreeNode node, int k, int[] count, int[] ans) {
        if (node == null) {
            return;
        }

        larger(node.right, k, count, ans);
        count[0]++;
        if (count[0] == k) {
            ans[0] = node.val;
            return;
        }
        larger(node.left, k, count, ans);
    }

    private static int kthSmall(TreeNode root, int k) {
        int[] ans = {-1};
        int[] count = {0};

        smaller(root, k, count, ans);
        return ans[0];
    }

    private static void smaller(TreeNode node, int k, int[] count, int[] ans) {
        if (node == null) {
            return;
        }

        smaller(node.left, k, count, ans);
        count[0]++;
        if (count[0] == k) {
            ans[0] = node.val;
            return;
        }
        smaller(node.right, k, count, ans);
    }
}