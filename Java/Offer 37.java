/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private StringBuilder preOrder = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        mySerialize(root);
        preOrder.deleteCharAt(preOrder.length() - 1);
        return preOrder.toString();
    }

    public void mySerialize(TreeNode root) {
        if (root == null) {
            preOrder.append("null,");
            return;
        } 
        preOrder.append(root.val);
        preOrder.append(",");
        mySerialize(root.left);
        mySerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] pre = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(pre));
        return myDeserialize(list);
    }

    public TreeNode myDeserialize(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode p = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        p.left = myDeserialize(list);
        p.right = myDeserialize(list);
        return p;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));