package BinaryTreeMaxPathSum;

public class MaxPathSum {
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

    public static int maxPathSum(TreeNode root){
        int res[] = new int[]{root.val};
        dfs(root, res);
        return res[0];
        
    }

    public static int dfs(TreeNode root, int res[]){
        if (root == null){
            return 0;
        }
        int left = Math.max(0, dfs(root.left, res));
        int right = Math.max(0, dfs(root.right, res));

        res[0] = Math.max(res[0], left+right+root.val);

        return root.val +  Math.max(left, right);
    }
    public static void main(String[] args) {
      TreeNode root = new TreeNode(-15, new TreeNode(10, null,null), new TreeNode(20, new TreeNode(15, new TreeNode(-5, null, null), null), new TreeNode(5, null, null)));  

      int res = maxPathSum(root);
      System.out.println(res);
    }
}
