package RightSideView;

import java.util.*;

public class RightSideView {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    
    

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;

    }

    public static void dfs(TreeNode root, int level, List<Integer> list) {
        if (root == null){
            return;
        }
        if (list.size() == level) {
            list.add(root.val);
        }
        dfs(root.right, level + 1,list);
        dfs(root.left, level + 1, list);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        System.out.println(rightSideView(root));
    }
}
