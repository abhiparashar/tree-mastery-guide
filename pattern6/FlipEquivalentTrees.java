package pattern6;

public class FlipEquivalentTrees {
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

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isEquiv(root1, root2);
    }

    private boolean isEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null || root1 != null && root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean noFlip = isEquiv(root1.left, root2.left) && isEquiv(root1.right, root2.right); // same structure
        boolean flip = isEquiv(root1.left, root2.right) && isEquiv(root1.right, root2.left); // can be flipped
        return noFlip || flip;
    }

    public static void main(String[] args) {
        FlipEquivalentTrees solution = new FlipEquivalentTrees();
        // Test Case 1: Flip equivalent
        TreeNode test1a = new TreeNode(1);
        test1a.left = new TreeNode(2);
        test1a.right = new TreeNode(3);
        test1a.left.left = new TreeNode(4);
        test1a.left.right = new TreeNode(5);
        test1a.right.left = new TreeNode(6);

        TreeNode test1b = new TreeNode(1);
        test1b.left = new TreeNode(3);
        test1b.right = new TreeNode(2);
        test1b.left.right = new TreeNode(6);
        test1b.right.left = new TreeNode(4);
        test1b.right.right = new TreeNode(5);

        System.out.println("Test 1: " + solution.flipEquiv(test1a, test1b)); // Expected: true

        // Test Case 2: Identical trees
        TreeNode test2a = new TreeNode(1);
        test2a.left = new TreeNode(2);
        test2a.right = new TreeNode(3);

        TreeNode test2b = new TreeNode(1);
        test2b.left = new TreeNode(2);
        test2b.right = new TreeNode(3);

        System.out.println("Test 2: " + solution.flipEquiv(test2a, test2b)); // Expected: true

        // Test Case 3: Not flip equivalent (different values)
        TreeNode test3a = new TreeNode(1);
        test3a.left = new TreeNode(2);

        TreeNode test3b = new TreeNode(1);
        test3b.left = new TreeNode(3);

        System.out.println("Test 3: " + solution.flipEquiv(test3a, test3b)); // Expected: false

        // Test Case 4: Both null
        System.out.println("Test 4: " + solution.flipEquiv(null, null)); // Expected: true

        // Test Case 5: One null
        TreeNode test5 = new TreeNode(1);
        System.out.println("Test 5: " + solution.flipEquiv(test5, null)); // Expected: false

        // Test Case 6: Single nodes with same value
        TreeNode test6a = new TreeNode(1);
        TreeNode test6b = new TreeNode(1);
        System.out.println("Test 6: " + solution.flipEquiv(test6a, test6b)); // Expected: true

        // Test Case 7: Different structure
        TreeNode test7a = new TreeNode(1);
        test7a.left = new TreeNode(2);
        test7a.right = new TreeNode(3);
        test7a.left.left = new TreeNode(4);

        TreeNode test7b = new TreeNode(1);
        test7b.left = new TreeNode(3);
        test7b.right = new TreeNode(2);
        test7b.right.right = new TreeNode(4);

        System.out.println("Test 7: " + solution.flipEquiv(test7a, test7b)); // Expected: true

    }
}
