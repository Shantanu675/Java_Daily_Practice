package Trees;

import java.util.Arrays;

public class ConstructBinaryTreePostIn {
    public static void main(String[] args) {
        int[] postorder = {40,50,20,60,30,10};
        int[] inorder = {40,20,50,10,60,30};

        TreeNode root = constructTree(postorder, inorder);
    }

    static int index = 0;
    private static TreeNode constructTree(int[] postorder, int[] inorder){
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int n = findPosition(root.val, inorder);
        index = postorder.length-2;
        construct(root, Arrays.copyOfRange(inorder, 0, n), Arrays.copyOfRange(inorder, n+1, inorder.length), postorder);
        return root;
    }

    private static int findPosition(int k, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }

    private static void construct(TreeNode node, int[] leftArr, int[] rightArr, int[] postorder){
        if(rightArr.length != 0){
            TreeNode rightNode = new TreeNode(postorder[index--]);
            node.right = rightNode;
            int n = findPosition(rightNode.val, rightArr);
            construct(rightNode, Arrays.copyOfRange(rightArr, 0, n), Arrays.copyOfRange(rightArr, n+1, rightArr.length), postorder);
        }
        if(leftArr.length != 0){
            TreeNode leftNode = new TreeNode(postorder[index--]);
            node.left = leftNode;
            int n = findPosition(leftNode.val, leftArr);
            construct(leftNode, Arrays.copyOfRange(leftArr, 0, n), Arrays.copyOfRange(leftArr, n+1, leftArr.length), postorder);
        }
    }
}
