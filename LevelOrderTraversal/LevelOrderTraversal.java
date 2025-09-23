package LevelOrderTraversal;

import java.util.*;

public class LevelOrderTraversal {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
        public TreeNode(int data, TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode > queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> l = new ArrayList<>();
            for(int i = queue.size(); i>= 1; i--){
                TreeNode node = queue.poll();
                if (node != null){
                    l.add(node.data);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (l.size() > 0){
                list.add(l);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null,null)));
        ArrayList<ArrayList<Integer>> ans = levelOrder(root);
        System.out.println(ans);
    }
}
