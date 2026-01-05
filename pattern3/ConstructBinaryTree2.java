package pattern3;

import java.util.HashMap;

public class ConstructBinaryTree2 {
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

    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.println(root.val + " ");
        printInorder(root.right);
    }

    public static void printPostorder(TreeNode root) {
        if (root == null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.val + " ");
    }

    private static int postIndex;
    private static HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderMap.clear();
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] postorder, int left, int right) {
        if (left > right)
            return null;

        int rootVal = postorder[postIndex--];

        int inorderIndex = inorderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.right = build(postorder, inorderIndex + 1, right);

        root.left = build(postorder, left, inorderIndex - 1);

        return root;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard tree
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        int[] inorder1 = { 9, 3, 15, 20, 7 };
        int[] postorder1 = { 9, 15, 7, 20, 3 };
        TreeNode root1 = buildTree(inorder1, postorder1);
        System.out.print("Test 1 Inorder: ");
        printInorder(root1); // Expected: 9 3 15 20 7
        System.out.println();
        System.out.print("Test 1 Postorder: ");
        printPostorder(root1); // Expected: 9 15 7 20 3
        System.out.println();

        // Test Case 2: Single node
        // 1
        int[] inorder2 = { 1 };
        int[] postorder2 = { 1 };
        TreeNode root2 = buildTree(inorder2, postorder2);
        System.out.print("Test 2 Inorder: ");
        printInorder(root2); // Expected: 1
        System.out.println();

        // Test Case 3: Left skewed tree
        // 3
        // /
        // 2
        // /
        // 1
        int[] inorder3 = { 1, 2, 3 };
        int[] postorder3 = { 1, 2, 3 };
        TreeNode root3 = buildTree(inorder3, postorder3);
        System.out.print("Test 3 Inorder: ");
        printInorder(root3); // Expected: 1 2 3
        System.out.println();
        System.out.print("Test 3 Postorder: ");
        printPostorder(root3); // Expected: 1 2 3
        System.out.println();

        // Test Case 4: Right skewed tree
        // 1
        // \
        // 2
        // \
        // 3
        int[] inorder4 = { 1, 2, 3 };
        int[] postorder4 = { 3, 2, 1 };
        TreeNode root4 = buildTree(inorder4, postorder4);
        System.out.print("Test 4 Inorder: ");
        printInorder(root4); // Expected: 1 2 3
        System.out.println();
        System.out.print("Test 4 Postorder: ");
        printPostorder(root4); // Expected: 3 2 1
        System.out.println();

        // Test Case 5: Larger tree
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        int[] inorder5 = { 4, 2, 5, 1, 3 };
        int[] postorder5 = { 4, 5, 2, 3, 1 };
        TreeNode root5 = buildTree(inorder5, postorder5);
        System.out.print("Test 5 Inorder: ");
        printInorder(root5); // Expected: 4 2 5 1 3
        System.out.println();
        System.out.print("Test 5 Postorder: ");
        printPostorder(root5); // Expected: 4 5 2 3 1
        System.out.println();
    }
}
