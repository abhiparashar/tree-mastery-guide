package pattern1.dfs;

public class SameTree {
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

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null && root2 != null || root2 == null && root1 != null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        SameTree sol = new SameTree();

        // Test 1: true
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Test 1: " + sol.isSameTree(p1, q1)); // true

        // Test 2: false (different structure)
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("Test 2: " + sol.isSameTree(p2, q2)); // false

        // Test 3: false (different values)
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println("Test 3: " + sol.isSameTree(p3, q3)); // false

        // Test 4: both null
        System.out.println("Test 4: " + sol.isSameTree(null, null)); // true

        // Test 5: one null
        System.out.println("Test 5: " + sol.isSameTree(p1, null)); // false

    }
}
