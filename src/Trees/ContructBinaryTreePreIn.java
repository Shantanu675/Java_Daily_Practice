package Trees;

import java.util.Arrays;

public class ContructBinaryTreePreIn {
    public static void main(String[] args) {
        int[] preorder = {10,20,40,50,30,60};
        int[] inorder = {40,20,50,10,60,30};

        TreeNode root = constructTree(preorder, inorder);
    }

    private static TreeNode constructTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int n = findPosition(preorder[0], inorder);
        construct(root, Arrays.copyOfRange(inorder, 0, n), Arrays.copyOfRange(inorder, n+1, inorder.length), preorder);
        return root;
    }

    private static int findPosition(int k, int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] == k){
                return j;
            }
        }
        return -1;
    }

    static int index = 1;
    private static void construct(TreeNode node, int[] leftArr, int[] rightArr, int[] preorder){
        if(leftArr.length != 0){
            TreeNode leftNode = new TreeNode(preorder[index]);
            node.left = leftNode;
            int n = findPosition(preorder[index++], leftArr);
            construct(leftNode, Arrays.copyOfRange(leftArr, 0, n), Arrays.copyOfRange(leftArr, n+1, leftArr.length), preorder);
        }
        if(rightArr.length != 0){
            TreeNode rightNode = new TreeNode(preorder[index]);
            node.right = rightNode;
            int n = findPosition(preorder[index++], rightArr);
            construct(rightNode, Arrays.copyOfRange(rightArr, 0, n), Arrays.copyOfRange(rightArr, n+1, rightArr.length), preorder);
        }
    }
}
