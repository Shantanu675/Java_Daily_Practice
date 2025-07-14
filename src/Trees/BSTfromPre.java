package Trees;

public class BSTfromPre {
    public static void main(String[] args) {
        int[] preorder =  {8, 5, 1, 7, 10, 12};
        TreeNode root = constructTree(preorder);
        System.out.println(root);
    }

    private static TreeNode constructTree(int[] preorder) {
        return construct(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private static TreeNode construct(int[] arr, int bound, int[] index) {
        if(index[0] == arr.length || arr[index[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(arr[index[0]++]);
        root.left = construct(arr, root.val, index);
        root.right = construct(arr, bound, index);

        return root;
    }
}
