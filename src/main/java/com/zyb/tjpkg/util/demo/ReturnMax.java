package com.zyb.tjpkg.util.demo;


import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by Yambo Zhang on 2020-04-26.
 */
public class ReturnMax {
    private static <E extends Comparable<E>> E maxCompute(Collection<E> collections) {
        E result = null;
        for (E e : collections) {
            if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);
        }
//        collections.stream().max()
        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "acc", "abcdzzzzz");
        System.out.println(maxCompute(list));
//        PriorityQueue
//        TreeNode
    }

    /*public static void Mirror(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) return;
        BinaryTreeNode tempNode = root.left;
        tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;

        Mirror(root.left);
        Mirror(root.right);
    }

    public static void Mirror(TreeNode root) {
//        TreeMap
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) return;
        BinaryTreeNode tempNode = root.left;
        tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;

        Mirror(root.left);
        Mirror(root.right);
    }*/

}
