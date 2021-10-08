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
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        mySerialize(root, sb);
        return sb.toString();
    }

    public void mySerialize(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
            sb.append(',');
            mySerialize(root.left, sb);
            mySerialize(root.right, sb);
        } else {
            sb.append("null,");
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tmp = data.split(",");
        List<String> nodes = new LinkedList(Arrays.asList(tmp)); 
        return myDeserialize(nodes);
    }

    public TreeNode myDeserialize(List<String> nodes) {
        if ("null".equals(nodes.get(0))) {
            nodes.remove(0);
            return null;
        }
        TreeNode p = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        p.left = myDeserialize(nodes);
        p.right = myDeserialize(nodes);
        return p;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));