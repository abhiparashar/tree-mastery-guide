package pattern4;

public class DiameterOfBinaryTree {
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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Test Case 1: [1,2,3,4,5] → Expected: 3
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.left = new TreeNode(4);
        test1.left.right = new TreeNode(5);
        System.out.println("Test 1: " + solution.diameterOfBinaryTree(test1));
        // Expected: 3

        // Test Case 2: [1,2] → Expected: 1
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        System.out.println("Test 2: " + solution.diameterOfBinaryTree(test2));
        // Expected: 1

        // Test Case 3: [1] → Expected: 0
        TreeNode test3 = new TreeNode(1);
        System.out.println("Test 3: " + solution.diameterOfBinaryTree(test3));
        // Expected: 0

        // Test Case 4: Diameter not through root
        // 1
        // /
        // 2
        // / \
        // 3 4
        // / \
        // 5 6
        // Longest path: 5 -> 3 -> 2 -> 4 -> 6 = 4 edges
        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(2);
        test4.left.left = new TreeNode(3);
        test4.left.right = new TreeNode(4);
        test4.left.left.left = new TreeNode(5);
        test4.left.right.right = new TreeNode(6);
        System.out.println("Test 4: " + solution.diameterOfBinaryTree(test4));
        // Expected: 4
    }
}
