package pattern1.dfs;

public class MinimumDepthOfTree {
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        MinimumDepthOfTree sol = new MinimumDepthOfTree();

        // Test 1: Answer = 2
        // 3
        // / \
        // 9 20
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        System.out.println("Test 1: " + sol.minDepth(t1)); // Expected: 2

        // Test 2: Answer = 3
        // 1
        // \
        // 2
        // \
        // 3
        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(3);
        System.out.println("Test 2: " + sol.minDepth(t2)); // Expected: 3

        // Test 3: Answer = 1 (single node)
        TreeNode t3 = new TreeNode(5);
        System.out.println("Test 3: " + sol.minDepth(t3)); // Expected: 1

        // Test 4: Answer = 0 (null tree)
        System.out.println("Test 4: " + sol.minDepth(null)); // Expected: 0

    }
}
