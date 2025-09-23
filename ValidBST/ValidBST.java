package ValidBST;


public class ValidBST {
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

    // Easiest method is to traverse inorder and save it in arraylist and then check if sorted or not.
    public static boolean isValidBST(TreeNode root){
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public static boolean dfs(TreeNode root, long left, long right){
        if (root == null){
            return true;
        }
        if (!(root.val > left && root.val < right)){
            return false;
        }
        return dfs(root.left, left, root.val) && dfs(root.right, root.val, right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1, null,null), new TreeNode(3, null, null));
        System.out.println(isValidBST(root));
    }
}
