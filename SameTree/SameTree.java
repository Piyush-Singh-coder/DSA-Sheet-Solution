package SameTree;

public class SameTree {
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

    public static boolean isSame(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 != null && root2 != null && root1.data == root2.data){
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        System.out.println(isSame(root1, root2));
    }
}
