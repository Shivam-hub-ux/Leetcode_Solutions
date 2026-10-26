import java.util.*;

class Solution {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        inorder(root, values);

        return buildTree(values, 0, values.size() - 1);
    }

    // Step 1: Store values in sorted order
    private void inorder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

    // Step 2: Build a balanced BST
    private TreeNode buildTree(List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildTree(values, left, mid - 1);
        root.right = buildTree(values, mid + 1, right);

        return root;
    }
}