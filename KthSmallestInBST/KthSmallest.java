package KthSmallestInBST;

import java.util.*;
public class KthSmallest {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val){
            this.val = val;
        }
        public TreeNode (int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static int kthSmallest(TreeNode root, int k){
        ArrayList <Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res.get(k-1);
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> res){
        if (root == null){
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(3, new TreeNode(2, null, null), null), new TreeNode(5, null, null));
        int k = 4;
        System.out.println(kthSmallest(root, k));
    }
}
