package Trees;

import java.util.*;

public class KDistFromNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n4.right = n8;
        System.out.println(kDist(root, n1, 2));
    }

    private static List<Integer> kDist(TreeNode root, TreeNode target, int n) {
        List<Integer> result = new ArrayList<>();

        HashMap<TreeNode, TreeNode> parentAssign = new HashMap<>();
        parentTrack(root, parentAssign);

        HashMap<TreeNode, Boolean> visit = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        visit.put(target, true);

        while(n != 0){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();

                if(node.left != null && visit.get(node.left) == null){
                    q.add(node.left);
                    visit.put(node.left, true);
                }
                if(node.right != null && visit.get(node.right) == null){
                    q.add(node.right);
                    visit.put(node.right, true);
                }
                if(parentAssign.get(node) != null && visit.get(parentAssign.get(node)) == null){
                    q.add(parentAssign.get(node));
                    visit.put(node, true);
                }
            }
            n--;
        }

        while(! q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }

    private static void parentTrack(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        map.put(root, null);

        while(! q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode current = q.poll();

                if(current.left != null){
                    map.put(current.left, current);
                    q.offer(current.left);
                }
                if(current.right != null){
                    map.put(current.right, current);
                    q.offer(current.right);
                }
            }
        }
    }
}
