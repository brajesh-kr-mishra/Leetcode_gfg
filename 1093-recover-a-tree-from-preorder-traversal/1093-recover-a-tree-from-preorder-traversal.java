/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode recoverFromPreorder(String t) {
        int n = t.length();
        TreeNode[] list = new TreeNode[10001];
        int root = 0, i = 0;
        while (i < n && t.charAt(i) != '-') {
            root = root * 10 + (t.charAt(i) - '0');
            i++;
        }
        list[0] = new TreeNode(root);

        while (i < n) {
            int count = 0;
            while (i < n && t.charAt(i) == '-') {
                i++;
                count++;
            }
            int node = 0;
            while (i < n && t.charAt(i) != '-') {
                node = node * 10 + (t.charAt(i) - '0');
                i++;
            }
            TreeNode child = new TreeNode(node);
            TreeNode parent = list[count - 1];
            if (parent.left == null)
                parent.left = child;
            else
                parent.right = child;

            list[count] = child;

        }

        // level order treversal

        return list[0];
    }
}