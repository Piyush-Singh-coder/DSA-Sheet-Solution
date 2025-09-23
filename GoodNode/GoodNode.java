package GoodNode;

public class GoodNode {
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

    public static int noOfGoodNodes(TreeNode root){
        int [] count = new int[1];
        dfs(root, root.val, count);
        return count[0];
    }

    public static void dfs(TreeNode node, int maxVal, int[] count){
        if (node == null){
            return;
        }
        if (node.val >= maxVal){
            maxVal = node.val;
            count[0] = count[0] +1;
        }
        dfs(node.left, maxVal, count);
        dfs(node.right, maxVal, count);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1, new TreeNode(3, null, null), null), new TreeNode(1, new TreeNode(1, null, null), new TreeNode(5, null, null)));
        System.out.println(noOfGoodNodes(root));
    }
}
