package pattern1.dfs;

public class SymmetricTree {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || right != null && left == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricTree solution = new SymmetricTree();

        // Test Case 1: Symmetric tree [1,2,2,3,4,4,3]
        // 1
        // / \
        // 2 2
        // / \ / \
        // 3 4 4 3
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(2);
        test1.left.left = new TreeNode(3);
        test1.left.right = new TreeNode(4);
        test1.right.left = new TreeNode(4);
        test1.right.right = new TreeNode(3);
        System.out.println("Test 1: " + solution.isSymmetric(test1) + " (Expected: true)");

        // Test Case 2: Not symmetric [1,2,2,null,3,null,3]
        // 1
        // / \
        // 2 2
        // \ \
        // 3 3
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(2);
        test2.left.right = new TreeNode(3);
        test2.right.right = new TreeNode(3);
        System.out.println("Test 2: " + solution.isSymmetric(test2) + " (Expected: false)");

        // Test Case 3: Single node
        // 1
        TreeNode test3 = new TreeNode(1);
        System.out.println("Test 3: " + solution.isSymmetric(test3) + " (Expected: true)");

        // Test Case 4: Empty tree
        TreeNode test4 = null;
        System.out.println("Test 4: " + solution.isSymmetric(test4) + " (Expected: true)");

        // Test Case 5: Different values [1,2,3]
        // 1
        // / \
        // 2 3
        TreeNode test5 = new TreeNode(1);
        test5.left = new TreeNode(2);
        test5.right = new TreeNode(3);
        System.out.println("Test 5: " + solution.isSymmetric(test5) + " (Expected: false)");

        // Test Case 6: Symmetric with same values [1,2,2]
        // 1
        // / \
        // 2 2
        TreeNode test6 = new TreeNode(1);
        test6.left = new TreeNode(2);
        test6.right = new TreeNode(2);
        System.out.println("Test 6: " + solution.isSymmetric(test6) + " (Expected: true)");
    }
}
