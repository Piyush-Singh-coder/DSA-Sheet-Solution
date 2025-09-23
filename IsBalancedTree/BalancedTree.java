package IsBalancedTree;

public class BalancedTree {
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
    public static boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh-rh) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int height (TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // More optimised Method

    public static boolean isBalancedTree(TreeNode root){
        return dfs(root)[0] == 1;
    }

    public static int[] dfs(TreeNode root){
        if (root == null){
            return new int[]{1,0};     // 0th position says true or false, 1th position says height of tree
        }
        int lh[] = dfs(root.left);
        int rh[] = dfs(root.right);

        boolean balanced = (lh[0] == 1 && rh[0] == 1) && (Math.abs(lh[1]-rh[1]) <= 1);
        int height = 1 + Math.max(lh[1],rh[1]);

        return new int[]{balanced ? 1 : 0 , height};
    }
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(4, null, null)));
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        System.out.println(isBalancedTree(root));
    }   
}
