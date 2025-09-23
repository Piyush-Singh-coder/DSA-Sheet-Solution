package SubTree;

public class SubTree {
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
    public static boolean isSubTree(TreeNode root, TreeNode subroot){
        if (root == null){
            return false;
        }
        if (subroot == null){
            return false;
        }
        if (isSame(root, subroot)){
            return true;
        }
        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
        
    }
    public static boolean isSame(TreeNode root, TreeNode subroot){
        if (root == null && subroot == null){
            return true;
        }
        if (root == null || subroot == null){
            return false;
        }

        if (root != null && subroot != null && root.data == subroot.data){
            return isSame(root.left, subroot.left) && isSame(root.right, subroot.right);
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        TreeNode subroot = new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null));

        System.out.println(isSubTree(root, subroot));
    }
}
