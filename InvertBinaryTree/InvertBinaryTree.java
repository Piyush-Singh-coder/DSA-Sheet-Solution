package InvertBinaryTree;

import java.util.*;
public class InvertBinaryTree {
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
    public static void inorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }

    // Invert Binary Tree
    public static TreeNode invertBinaryTree (TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        return root;
    }
    public static TreeNode invertUsingStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3,null, null));
        inorderTraversal(root);
        System.out.println();
        invertBinaryTree(root);
        // invertUsingStack(root);
        inorderTraversal(root);
    }
}
