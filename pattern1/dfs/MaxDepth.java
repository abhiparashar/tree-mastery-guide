package pattern1.dfs;

public class MaxDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public int maxDepthCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = maxDepthCount(root.left);
        int rightCount = maxDepthCount(root.right);
        return Math.max(leftCount, rightCount) + 1;
    }

    public static void main(String[] args) {

    }
}
