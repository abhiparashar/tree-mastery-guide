package pattern6;

public class BalancedTreeOptimized {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return balanced(root) != -1;
    }

    private int balanced(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = balanced(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = balanced(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BalancedTreeOptimized solution = new BalancedTreeOptimized();

        // Test 1: Balanced tree
        TreeNode test1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println("Test 1 (Balanced): " + solution.isBalanced(test1));
        // Expected: true

        // Test 2: Unbalanced - left skewed
        TreeNode test2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        null),
                null);
        System.out.println("Test 2 (Unbalanced left skewed): " + solution.isBalanced(test2));
        // Expected: false

        // Test 3: Single node
        TreeNode test3 = new TreeNode(1);
        System.out.println("Test 3 (Single node): " + solution.isBalanced(test3));
        // Expected: true

        // Test 4: Empty tree
        System.out.println("Test 4 (Empty tree): " + solution.isBalanced(null));
        // Expected: true

        // Test 5: Two nodes
        TreeNode test5 = new TreeNode(1, new TreeNode(2), null);
        System.out.println("Test 5 (Two nodes): " + solution.isBalanced(test5));
        // Expected: true

        // Test 6: Complete binary tree
        TreeNode test6 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        System.out.println("Test 6 (Complete binary tree): " + solution.isBalanced(test6));
        // Expected: true

        // Test 7: Unbalanced at deeper level
        TreeNode test7 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                null),
                        null),
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4))));
        System.out.println("Test 7 (Unbalanced at deeper level): " + solution.isBalanced(test7));
        // Expected: false

        // Test 8: Almost unbalanced but still balanced
        TreeNode test8 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        null),
                new TreeNode(2));
        System.out.println("Test 8 (Almost unbalanced but balanced): " + solution.isBalanced(test8));
        // Expected: true

        // Test 9: Large balanced tree
        TreeNode test9 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        System.out.println("Test 9 (Large balanced tree): " + solution.isBalanced(test9));
        // Expected: true

        // Test 10: Tricky - looks balanced locally but unbalanced globally
        TreeNode test10 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                null),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        null));
        System.out.println("Test 10 (Unbalanced globally): " + solution.isBalanced(test10));
        // Expected: false
    }
}
