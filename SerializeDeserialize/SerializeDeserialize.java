package SerializeDeserialize;

import java.util.*;

public class SerializeDeserialize {
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
    public static String serialize(TreeNode root){
        ArrayList<String> res = new ArrayList<>();
        dfs(root, res);
        return String.join(",", res);
    }
    public static void dfs(TreeNode root, ArrayList<String> res){
        if (root == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfs(root.left, res);
        dfs(root.right, res);
    }
    
    // Deserialize
    public static TreeNode deserialize(String data){
        String[] val = data.split(",");
        int []i = {0};
        return dfsDeserialize(val, i);
    }
    public static TreeNode dfsDeserialize(String[] val, int[] i){
        if (val[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(val, i);
        node.right = dfsDeserialize(val, i);
        return node;
    }
    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
       TreeNode root = new TreeNode(4, new TreeNode(3, new TreeNode(2, null, null), null), new TreeNode(5, null, null));
       String res = serialize(root);
       System.out.println(res);  
       TreeNode node = deserialize(res);
       inOrder(node);
    }
}
