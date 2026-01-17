package pattern6;

public class UnivaluedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        return checkUnivalTree(root);
    }

    public boolean checkUnivalTree(TreeNode root) {
        if (root == null)
            return true;

        if (root.left != null && root.val != root.left.val) {
            return false;
        }

        if (root.right != null && root.val != root.right.val) {
            return false;
        }

        return checkUnivalTree(root.left) && checkUnivalTree(root.right);
    }

    public static void main(String[] args) {
        UnivaluedBinaryTree solution = new UnivaluedBinaryTree();

        // Test Case 1: All same values
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(1);
        test1.right = new TreeNode(1);
        test1.left.left = new TreeNode(1);
        test1.left.right = new TreeNode(1);
        test1.right.right = new TreeNode(1);
        System.out.println("Test 1: " + solution.isUnivalTree(test1)); // Expected: true

        // Test Case 2: Different value in subtree
        TreeNode test2 = new TreeNode(2);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(2);
        test2.left.left = new TreeNode(5);
        test2.left.right = new TreeNode(2);
        System.out.println("Test 2: " + solution.isUnivalTree(test2)); // Expected: false

        // Test Case 3: Single node
        TreeNode test3 = new TreeNode(7);
        System.out.println("Test 3: " + solution.isUnivalTree(test3)); // Expected: true

        // Test Case 4: Two nodes same value
        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(1);
        System.out.println("Test 4: " + solution.isUnivalTree(test4)); // Expected: true

        // Test Case 5: Two nodes different values
        TreeNode test5 = new TreeNode(1);
        test5.left = new TreeNode(2);
        System.out.println("Test 5: " + solution.isUnivalTree(test5)); // Expected: false

        // Test Case 6: All zeros
        TreeNode test6 = new TreeNode(0);
        test6.left = new TreeNode(0);
        test6.right = new TreeNode(0);
        System.out.println("Test 6: " + solution.isUnivalTree(test6)); // Expected: true

        // Test Case 7: Right child different
        TreeNode test7 = new TreeNode(5);
        test7.left = new TreeNode(5);
        test7.right = new TreeNode(3);
        System.out.println("Test 7: " + solution.isUnivalTree(test7)); // Expected: false
    }
}
