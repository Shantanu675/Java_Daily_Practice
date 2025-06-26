package Trees;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Pair{
    TreeNode node;
    int num;

    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}

public class PreInPostInSingle {
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

        System.out.println(Arrays.toString(traversing(root).toArray()));
    }

    private static List<List<Integer>> traversing(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        if(root == null) return result;

        while (! st.empty()){
            Pair current = st.pop();

            if(current.num == 1){
                preorder.add(current.node.val);
                current.num++;
                st.push(current);

                if(current.node.left != null){
                    st.push(new Pair(current.node.left, 1));
                }
            }

            else if(current.num == 2){
                inorder.add(current.node.val);
                current.num++;
                st.push(current);

                if (current.node.right != null){
                    st.push(new Pair(current.node.right, 1));
                }
            }

            else {
                postorder.add(current.node.val);
            }
        }
        result.add(preorder);
        result.add(inorder);
        result.add(postorder);
        return result;
    }
}
