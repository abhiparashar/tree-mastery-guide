package pattern4;

public class LongestUnivaluePath {
    private int maxPath = 0;

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

    public int longestUnivaluePath(TreeNode root) {
        maxPath = 0;
        if (root == null)
            return 0;
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = 0;
        int rightPath = 0;

        if (root.left != null && root.val == root.left.val) {
            leftPath = left + 1;
        }

        if (root.right != null && root.val == root.right.val) {
            rightPath = right + 1;
        }

        // Update max path (path that goes through current node)
        maxPath = Math.max(maxPath, leftPath + rightPath);

        // Return the longer single path for the parent
        return Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {
        LongestUnivaluePath solution = new LongestUnivaluePath();

        // Test Case 1: Example from LeetCode
        // 5
        // / \
        // 4 5
        // / \ \
        // 1 1 5
        TreeNode test1 = new TreeNode(5);
        test1.left = new TreeNode(4);
        test1.right = new TreeNode(5);
        test1.left.left = new TreeNode(1);
        test1.left.right = new TreeNode(1);
        test1.right.right = new TreeNode(5);
        System.out.println("Test 1: " + solution.longestUnivaluePath(test1));
        // Expected: 2 (path: 5->5->5)
        // solution.maxPath = 0; // Reset for next test

        // Test Case 2: All same values
        // 1
        // / \
        // 1 1
        // / \
        // 1 1
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(1);
        test2.right = new TreeNode(1);
        test2.left.left = new TreeNode(1);
        test2.left.right = new TreeNode(1);
        System.out.println("Test 2: " + solution.longestUnivaluePath(test2));
        // Expected: 4 (entire tree)
        // solution.maxPath = 0;

        // Test Case 3: No same adjacent values
        // 1
        // / \
        // 2 3
        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        test3.right = new TreeNode(3);
        System.out.println("Test 3: " + solution.longestUnivaluePath(test3));
        // Expected: 0
        // solution.maxPath = 0;

        // Test Case 4: Single node
        TreeNode test4 = new TreeNode(1);
        System.out.println("Test 4: " + solution.longestUnivaluePath(test4));
        // Expected: 0
        // solution.maxPath = 0;

        // Test Case 5: Linear path with same values
        // 2
        // /
        // 2
        // /
        // 2
        TreeNode test5 = new TreeNode(2);
        test5.left = new TreeNode(2);
        test5.left.left = new TreeNode(2);
        System.out.println("Test 5: " + solution.longestUnivaluePath(test5));
        // Expected: 2
        // solution.maxPath = 0;

        // Test Case 6: Complex tree
        // 1
        // / \
        // 4 5
        // / \ \
        // 4 4 5
        TreeNode test6 = new TreeNode(1);
        test6.left = new TreeNode(4);
        test6.right = new TreeNode(5);
        test6.left.left = new TreeNode(4);
        test6.left.right = new TreeNode(4);
        test6.right.right = new TreeNode(5);
        System.out.println("Test 6: " + solution.longestUnivaluePath(test6));
        // Expected: 2 (path: 4->4->4 or 5->5)
        // solution.maxPath = 0;

        // Test Case 7: Null tree
        System.out.println("Test 7: " + solution.longestUnivaluePath(null));
        // Expected: 0
    }
}
