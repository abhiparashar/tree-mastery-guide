package pattern1.dfs;

public class PathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        PathSum solution = new PathSum();

        // 5
        // / \
        // 4 8
        // / / \
        // 11 13 4
        // / \ \
        // 7 2 1
        TreeNode test1 = new TreeNode(5);
        test1.left = new TreeNode(4);
        test1.right = new TreeNode(8);
        test1.left.left = new TreeNode(11);
        test1.right.left = new TreeNode(13);
        test1.right.right = new TreeNode(4);
        test1.left.left.left = new TreeNode(7);
        test1.left.left.right = new TreeNode(2);
        test1.right.right.right = new TreeNode(1);

        System.out.println("Test 1: " + solution.hasPathSum(test1, 22) + " (Expected: true)");
        System.out.println("Test 2: " + solution.hasPathSum(test1, 26) + " (Expected: true)");
        System.out.println("Test 3: " + solution.hasPathSum(test1, 18) + " (Expected: true)");
        System.out.println("Test 4: " + solution.hasPathSum(test1, 27) + " (Expected: true)");
        System.out.println("Test 5: " + solution.hasPathSum(test1, 100) + " (Expected: false)");

        // 1
        // / \
        // 2 3
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        System.out.println("Test 6: " + solution.hasPathSum(test2, 1) + " (Expected: false)");
        System.out.println("Test 7: " + solution.hasPathSum(test2, 3) + " (Expected: true)");
        System.out.println("Test 8: " + solution.hasPathSum(test2, 4) + " (Expected: true)");

        // null
        TreeNode test3 = null;
        System.out.println("Test 9: " + solution.hasPathSum(test3, 0) + " (Expected: false)");

        // 1
        TreeNode test4 = new TreeNode(1);
        System.out.println("Test 10: " + solution.hasPathSum(test4, 1) + " (Expected: true)");
        System.out.println("Test 11: " + solution.hasPathSum(test4, 2) + " (Expected: false)");

        // 1
        // /
        // 2
        TreeNode test5 = new TreeNode(1);
        test5.left = new TreeNode(2);
        System.out.println("Test 12: " + solution.hasPathSum(test5, 3) + " (Expected: true)");
        System.out.println("Test 13: " + solution.hasPathSum(test5, 1) + " (Expected: false)");
    }
}
