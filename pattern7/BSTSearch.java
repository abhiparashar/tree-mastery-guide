public class BSTSearch {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        BSTSearch solution = new BSTSearch();

        // Build tree: 4
        // / \
        // 2 7
        // / \
        // 1 3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Test 1: Search 3 → Should find node with value 3
        TreeNode result1 = solution.searchBST(root, 3);
        System.out.println("Test 1 - Search 3: " +
                (result1 != null ? result1.val : "null") +
                " | Expected: 3");

        // Test 2: Search 5 → Should return null
        TreeNode result2 = solution.searchBST(root, 5);
        System.out.println("Test 2 - Search 5: " +
                (result2 != null ? result2.val : "null") +
                " | Expected: null");

        // Test 3: Search 4 (root) → Should find root
        TreeNode result3 = solution.searchBST(root, 4);
        System.out.println("Test 3 - Search 4: " +
                (result3 != null ? result3.val : "null") +
                " | Expected: 4");

        // Test 4: Search 1 (leaf) → Should find leaf
        TreeNode result4 = solution.searchBST(root, 1);
        System.out.println("Test 4 - Search 1: " +
                (result4 != null ? result4.val : "null") +
                " | Expected: 1");

        // Test 5: Search 7 → Should find right child
        TreeNode result5 = solution.searchBST(root, 7);
        System.out.println("Test 5 - Search 7: " +
                (result5 != null ? result5.val : "null") +
                " | Expected: 7");

        // Test 6: Empty tree
        TreeNode result6 = solution.searchBST(null, 5);
        System.out.println("Test 6 - Empty tree: " +
                (result6 != null ? result6.val : "null") +
                " | Expected: null");
    }
}
