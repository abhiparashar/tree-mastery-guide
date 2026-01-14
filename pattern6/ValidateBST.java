package pattern6;

public class ValidateBST {
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

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ValidateBST solution = new ValidateBST();

        // Test 1: Valid BST
        TreeNode test1 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(4)),
                new TreeNode(7,
                        null,
                        new TreeNode(9)));
        System.out.println("Test 1 (Valid BST): " + solution.isValidBST(test1));
        // Expected: true

        // Test 2: Invalid BST - right child of left subtree violates BST
        TreeNode test2 = new TreeNode(5,
                new TreeNode(1,
                        null,
                        new TreeNode(6) // 6 > 5, but it's in left subtree!
                ),
                new TreeNode(7));
        System.out.println("Test 2 (Invalid - violation in subtree): " +
                solution.isValidBST(test2));
        // Expected: false

        // Test 3: Single node
        TreeNode test3 = new TreeNode(1);
        System.out.println("Test 3 (Single node): " + solution.isValidBST(test3));
        // Expected: true

        // Test 4: Empty tree
        System.out.println("Test 4 (Empty tree): " + solution.isValidBST(null));
        // Expected: true

        // Test 5: Two nodes - valid
        TreeNode test5 = new TreeNode(2, new TreeNode(1), null);
        System.out.println("Test 5 (Two nodes valid): " +
                solution.isValidBST(test5));
        // Expected: true

        // Test 6: Two nodes - invalid
        TreeNode test6 = new TreeNode(1, new TreeNode(2), null);
        System.out.println("Test 6 (Two nodes invalid): " +
                solution.isValidBST(test6));
        // Expected: false

        // Test 7: Duplicate values
        TreeNode test7 = new TreeNode(5,
                new TreeNode(5),
                new TreeNode(7));
        System.out.println("Test 7 (Duplicate values): " + solution.isValidBST(test7));
        // Expected: false (BST requires strict inequality)

        // Test 8: All left children
        TreeNode test8 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(3,
                                new TreeNode(2),
                                null),
                        null),
                null);
        System.out.println("Test 8 (All left children): " +
                solution.isValidBST(test8));
        // Expected: true

        // Test 9: Integer boundaries
        TreeNode test9 = new TreeNode(Integer.MAX_VALUE);
        System.out.println("Test 9 (Max integer): " + solution.isValidBST(test9));
        // Expected: true

        // Test 10: Tricky case - looks valid locally but invalid globally
        TreeNode test10 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3),
                        new TreeNode(15) // 15 > 10, violates BST property!
                ),
                new TreeNode(20));
        System.out.println("Test 10 (Locally valid, globally invalid): " +
                solution.isValidBST(test10));
        // Expected: false
    }
}
