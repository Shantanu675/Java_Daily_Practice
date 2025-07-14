package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class SerializaDeserialize {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(13);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        String ser = serialize(root);
        System.out.println(ser);
        TreeNode r = deserialize(ser);
    }

    private static TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode curr = q.poll();

            if(! values[i].equals("null")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                curr.left = leftNode;
                q.offer(leftNode);
            }

            if(! values[++i].equals("null")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                curr.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;
    }

    private static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root == null) return str.toString();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (! q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                str.append("null ");
                continue;
            }else {
                str.append(curr.val).append(" ");
            }

            q.offer(curr.left);
            q.offer(curr.right);
        }
        return str.toString();
    }
}
