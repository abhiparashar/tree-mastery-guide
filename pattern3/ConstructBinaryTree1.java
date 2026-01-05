package pattern3;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree1 {

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

    public static void printPreorder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    private static int preIndex = 0;
    private static Map<Integer, Integer> inorderMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // Reset for each new tree!
        preIndex = 0;
        inorderMap.clear();
        TreeNode root = null;
        if (preorder.length == 0 || inorder.length == 0) {
            return root;
        }

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIndex++];

        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderMap.get(rootVal);

        root.left = build(preorder, left, inorderIndex - 1);

        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] preorder1 = { 3, 9, 20, 15, 7 };
        int[] inorder1 = { 9, 3, 15, 20, 7 };
        TreeNode root1 = buildTree(preorder1, inorder1);
        System.out.print("Test 1 Preorder: ");
        printPreorder(root1); // Expected: 3 9 20 15 7
        System.out.println();

        // Test Case 2: Single node
        int[] preorder2 = { 1 };
        int[] inorder2 = { 1 };
        TreeNode root2 = buildTree(preorder2, inorder2);
        System.out.print("Test 2 Preorder: ");
        printPreorder(root2); // Expected: 1
        System.out.println();

        // Test Case 3: Left skewed tree
        int[] preorder3 = { 3, 2, 1 };
        int[] inorder3 = { 1, 2, 3 };
        TreeNode root3 = buildTree(preorder3, inorder3);
        System.out.print("Test 3 Preorder: ");
        printPreorder(root3); // Expected: 3 2 1
        System.out.println();

        // Test Case 4: Right skewed tree
        int[] preorder4 = { 1, 2, 3 };
        int[] inorder4 = { 1, 2, 3 };
        TreeNode root4 = buildTree(preorder4, inorder4);
        System.out.print("Test 4 Preorder: ");
        printPreorder(root4); // Expected: 1 2 3
        System.out.println();
    }
}
