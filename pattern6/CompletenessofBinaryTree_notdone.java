package pattern6;

public class CompletenessofBinaryTree_notdone {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        CompletenessofBinaryTree_notdone solution = new CompletenessofBinaryTree_notdone();

        // Test case 1: [1,2,3,4,5,6] - Complete
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        System.out.println("Test 1: " + solution.isCompleteTree(root1)); // Expected: true

        // Test case 2: [1,2,3,4,5,null,7] - Not complete
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(7);
        System.out.println("Test 2: " + solution.isCompleteTree(root2)); // Expected: false

        // Test case 3: [1] - Single node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3: " + solution.isCompleteTree(root3)); // Expected: true

        // Test case 4: [1,2,3,4,5,6,7] - Perfect binary tree
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(7);
        System.out.println("Test 4: " + solution.isCompleteTree(root4)); // Expected: true

        // Test case 5: [1,2,3,4,null,null,7] - Not complete
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.right.right = new TreeNode(7);
        System.out.println("Test 5: " + solution.isCompleteTree(root5)); // Expected: false
    }
}
