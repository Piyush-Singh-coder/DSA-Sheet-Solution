package LowestCommonAncestor;

public class LCA {
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || p == null || q == null){
            return null;
        }
        if (Math.max(p.data, q.data) < root.data){
            return lowestCommonAncestor(root.left, p, q);
        }else if(Math.min(p.data, q.data) > root.data){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        TreeNode curr = root;

        while(curr != null){
            if ((p.data > curr.data ) && (q.data > curr.data)){
                curr = curr.right;
            }else if((p.data < curr.data) && (q.data < curr.data)){
                curr = curr.left;
            }else{
                return curr;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(1, new TreeNode(1, null, null), new TreeNode(4, null, null)), new TreeNode(4, null, null)), new TreeNode(8, new TreeNode(7, null, null), new TreeNode(9, null, null)));
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(8);
        System.out.println(lca(root, p, q).data);
    }
}
