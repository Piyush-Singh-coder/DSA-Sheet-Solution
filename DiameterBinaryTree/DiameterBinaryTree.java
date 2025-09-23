package DiameterBinaryTree;

public class DiameterBinaryTree {
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

    // public static int height (TreeNode root){
    //     if (root == null){
    //         return 0;
    //     }
    //     return 1+ Math.max(height(root.left), height(root.left));
    // }
    // public static int diameter (TreeNode root){
    //     if (root == null){
    //         return 0;
    //     }
    //     int lh = height(root.left);
    //     int rh = height(root.right);
    //     return Math.max(Math.max(diameter(root.left), diameter(root.right)), lh+rh);
    // }

    public static int diameterOfBinary(TreeNode root){
        int res[] = new int[1];
        dfs(root, res);
        return res[0];
    }

    public static int dfs(TreeNode root, int res[]){
        if (root == null){
            return 0;
        }
        int lh = dfs(root.left, res);
        int rh = dfs(root.right, res);
        res[0] = Math.max(res[0], lh+rh);

        return 1+ Math.max(dfs(root.left, res), dfs(root.right, res));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(4, null, null)));
        System.out.println(diameterOfBinary(root));
    } 
}
