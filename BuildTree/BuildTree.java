package BuildTree;

public class BuildTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int preIndex = 0; // global pointer for preorder traversal

    public int search(int[] inorder, int key, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // Take current root from preorder
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // Find root index in inorder
        int index = search(inorder, root.val, left, right);

        // Recursively build left & right subtrees
        root.left = helper(preorder, inorder, left, index - 1);
        root.right = helper(preorder, inorder, index + 1, right);

        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int preorder[] = {1, 2, 3, 4};
        int inorder[] = {2, 1, 3, 4};
        BuildTree build = new BuildTree();
        TreeNode root = build.buildTree(preorder, inorder);
        inOrder(root);  // should print inorder sequence: 2 1 3 4
    }
}
