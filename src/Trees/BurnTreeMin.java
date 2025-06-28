package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BurnTreeMin {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(timeToBurnTree(root, n1));
    }

    private static int timeToBurnTree(TreeNode root, TreeNode target) {
        int time = 0;

        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        parentAss(root, parent_track);

        HashMap<TreeNode, Boolean> visit = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        visit.put(target, true);
        q.offer(target);

        while (! q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null && visit.get(curr.left) == null){
                    q.offer(curr.left);
                    visit.put(curr.left, true);
                }
                if(curr.right != null && visit.get(curr.right) == null){
                    q.offer(curr.right);
                    visit.put(curr.right, true);
                }
                if(parent_track.get(curr) != null && visit.get(parent_track.get(curr)) == null){
                    q.offer(parent_track.get(curr));
                    visit.put(parent_track.get(curr), true);
                }
            }
            time++;
        }
        return time-1;
    }

    private static void parentAss(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root, null);

        while (! q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode current = q.poll();

                if(current.left != null){
                    q.offer(current.left);
                    map.put(current.left, current);
                }
                if(current.right != null){
                    q.offer(current.right);
                    map.put(current.right, current);
                }
            }
        }
    }
}
