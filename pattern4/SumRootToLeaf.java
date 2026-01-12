package pattern4;

public class SumRootToLeaf {
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

    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }

    public int findSum(TreeNode root, int currentSum) {
        if (root == null)
            return 0;

        currentSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null)
            return currentSum;

        return findSum(root.left, currentSum) + findSum(root.right, currentSum);
    }

    public static void main(String[] args) {
        SumRootToLeaf solution = new SumRootToLeaf();

        // Test Case 1: [1,2,3] → Expected: 25
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        System.out.println("Test 1: " + solution.sumNumbers(test1) + " (Expected: 25)");

        // Test Case 2: [4,9,0,5,1] → Expected: 1026
        TreeNode test2 = new TreeNode(4);
        test2.left = new TreeNode(9);
        test2.right = new TreeNode(0);
        test2.left.left = new TreeNode(5);
        test2.left.right = new TreeNode(1);
        System.out.println("Test 2: " + solution.sumNumbers(test2) + " (Expected: 1026)");

        // Test Case 3: Single node [5] → Expected: 5
        TreeNode test3 = new TreeNode(5);
        System.out.println("Test 3: " + solution.sumNumbers(test3) + " (Expected: 5)");

        // Test Case 4: [1,0] → Expected: 10
        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(0);
        System.out.println("Test 4: " + solution.sumNumbers(test4) + " (Expected: 10)");
    }
}
