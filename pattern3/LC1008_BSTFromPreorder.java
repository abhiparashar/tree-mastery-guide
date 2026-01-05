package pattern3;

public class LC1008_BSTFromPreorder {
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

    private void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null)
            return;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);
        printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    public TreeNode bstFromPreorder(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end)
            return null;
        TreeNode node = new TreeNode(nums[start]);
        int splitIndex = start + 1;
        while (splitIndex <= end && nums[splitIndex] < nums[start]) {
            splitIndex++;
        }
        node.left = build(nums, start + 1, splitIndex - 1);
        node.right = build(nums, splitIndex, end);
        return node;
    }

    public static void main(String[] args) {
        LC1008_BSTFromPreorder solution = new LC1008_BSTFromPreorder();

        // Test Case 1
        int[] pre1 = { 8, 5, 1, 7, 10, 12 };
        TreeNode result1 = solution.bstFromPreorder(pre1);
        System.out.println("Test 1: [8,5,1,7,10,12]");
        solution.printTree(result1, "", false);

        // Test Case 2
        int[] pre2 = { 4, 2 };
        TreeNode result2 = solution.bstFromPreorder(pre2);
        System.out.println("\nTest 2: [4,2]");
        solution.printTree(result2, "", false);

        // Test Case 3
        int[] pre3 = { 1, 3 };
        TreeNode result3 = solution.bstFromPreorder(pre3);
        System.out.println("\nTest 3: [1,3]");
        solution.printTree(result3, "", false);

        // Test Case 4: Single element
        int[] pre4 = { 5 };
        TreeNode result4 = solution.bstFromPreorder(pre4);
        System.out.println("\nTest 4: [5]");
        solution.printTree(result4, "", false);

        // Test Case 5
        int[] pre5 = { 10, 5, 2, 7, 15, 12, 20 };
        TreeNode result5 = solution.bstFromPreorder(pre5);
        System.out.println("\nTest 5: [10,5,2,7,15,12,20]");
        solution.printTree(result5, "", false);

    }
}
