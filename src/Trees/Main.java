package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /// /////////////////////////////////////////////////
//        Scanner sc = new Scanner(System.in);
//        BinaryTree bt = new BinaryTree();
//        bt.populate(sc);
//        bt.prettyDisplay();

        /// //////////////////////////////////////////////////
//        BST tree = new BST();
//        //int[] nums = {5,2,7,1,4,6,9,8,3,10};
//        //tree.populate(nums);
//
//        int[] nums = {1,2,3,4,5,6,7,8,9,10};
//        tree.sortedPopulate(nums);
//        tree.display();

        /// ///////////////////////////////////////////////////
//        AVL tree = new AVL();
//        for (int i = 0; i < 1000; i++) {
//            tree.insert(i);
//        }
//
//        System.out.println(tree.height());

        /// /////////////////////////////////////////////////////

        int[] arr = {3,8,6,7,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        System.out.println(tree.query(2,6));
    }
}
