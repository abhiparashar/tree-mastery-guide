public class BSTInsert {

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

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        BSTInsert solution = new BSTInsert();

        // Test 1: Insert into existing tree
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);

        System.out.print("Test 1 - Before insert 3: ");
        solution.inorder(root1);
        System.out.println();

        root1 = solution.insertIntoBST(root1, 3);
        System.out.print("Test 1 - After insert 3:  ");
        solution.inorder(root1);
        System.out.println(" | Expected: 1 2 3 4 7");
        System.out.println();

        // Test 2: Insert into empty tree
        TreeNode root2 = null;
        root2 = solution.insertIntoBST(root2, 5);
        System.out.print("Test 2 - Insert in empty: ");
        solution.inorder(root2);
        System.out.println(" | Expected: 5");
        System.out.println();

        // Test 3: Insert larger value
        TreeNode root3 = new TreeNode(4);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(7);

        System.out.print("Test 3 - Before insert 9: ");
        solution.inorder(root3);
        System.out.println();

        root3 = solution.insertIntoBST(root3, 9);
        System.out.print("Test 3 - After insert 9:  ");
        solution.inorder(root3);
        System.out.println(" | Expected: 2 4 7 9");
        System.out.println();

        // Test 4: Insert smaller value
        TreeNode root4 = new TreeNode(4);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(7);

        System.out.print("Test 4 - Before insert 1: ");
        solution.inorder(root4);
        System.out.println();

        root4 = solution.insertIntoBST(root4, 1);
        System.out.print("Test 4 - After insert 1:  ");
        solution.inorder(root4);
        System.out.println(" | Expected: 1 2 4 7");
        System.out.println();

        // Test 5: Multiple inserts
        TreeNode root5 = new TreeNode(5);
        root5 = solution.insertIntoBST(root5, 3);
        root5 = solution.insertIntoBST(root5, 7);
        root5 = solution.insertIntoBST(root5, 1);
        root5 = solution.insertIntoBST(root5, 9);

        System.out.print("Test 5 - Multiple inserts: ");
        solution.inorder(root5);
        System.out.println(" | Expected: 1 3 5 7 9");
    }
}
