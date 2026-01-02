package pattern1.dfs;

public class CountNodes {
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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public static void main(String[] args) {
        CountNodes sol = new CountNodes();

        // Test 1: [1,2,3,4,5,6] → Expected: 6
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        System.out.println(sol.countNodes(root1)); // 6

        // Test 2: null → Expected: 0
        System.out.println(sol.countNodes(null)); // 0

        // Test 3: [1] → Expected: 1
        TreeNode root3 = new TreeNode(1);
        System.out.println(sol.countNodes(root3)); // 1

        // Test 4: [1,2,3,4,5,6,7] perfect tree → Expected: 7
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(7);
        System.out.println(sol.countNodes(root4)); // 7

        // Test 5: [1,2] → Expected: 2
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        System.out.println(sol.countNodes(root5)); // 2
    }
}
