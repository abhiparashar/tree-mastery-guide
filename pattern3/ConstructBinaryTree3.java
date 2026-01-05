package pattern3;

import java.util.HashMap;

public class ConstructBinaryTree3 {
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

    public static void printPostorder(TreeNode root) {
        if (root == null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.val + " ");
    }

    private static int preIndex = 0;
    private static HashMap<Integer, Integer> postMap = new HashMap<>();

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preIndex = 0;
        postMap.clear();
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return build(preorder, 0, postorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int left, int right) {
        if (left > right)
            return null;

        int rootVal = preorder[preIndex++];

        TreeNode root = new TreeNode(rootVal);

        // If only one node in range, it's a leaf
        if (left == right) {
            return root;
        }

        // Find LEFT CHILD's position (not root's position!)
        int leftChildVal = preorder[preIndex];
        int leftChildPostIndex = postMap.get(leftChildVal);

        root.left = build(preorder, left, leftChildPostIndex);

        root.right = build(preorder, leftChildPostIndex + 1, right - 1);

        return root;
    }

    public static void main(String[] args) {

        // Test Case 1: Standard tree
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7
        int[] preorder1 = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder1 = { 4, 5, 2, 6, 7, 3, 1 };
        TreeNode root1 = constructFromPrePost(preorder1, postorder1);
        System.out.print("Test 1 Preorder: ");
        printPreorder(root1); // Expected: 1 2 4 5 3 6 7
        System.out.println();
        System.out.print("Test 1 Postorder: ");
        printPostorder(root1); // Expected: 4 5 2 6 7 3 1
        System.out.println();

        // Test Case 2: Single node
        // 1
        int[] preorder2 = { 1 };
        int[] postorder2 = { 1 };
        TreeNode root2 = constructFromPrePost(preorder2, postorder2);
        System.out.print("Test 2 Preorder: ");
        printPreorder(root2); // Expected: 1
        System.out.println();

        // Test Case 3: Two nodes (ambiguous case)
        // 1 OR 1
        // / \
        // 2 2
        // Both are valid!
        int[] preorder3 = { 1, 2 };
        int[] postorder3 = { 2, 1 };
        TreeNode root3 = constructFromPrePost(preorder3, postorder3);
        System.out.print("Test 3 Preorder: ");
        printPreorder(root3); // Expected: 1 2
        System.out.println();

        // Test Case 4: Three nodes - left heavy
        // 1
        // /
        // 2
        // /
        // 3
        int[] preorder4 = { 1, 2, 3 };
        int[] postorder4 = { 3, 2, 1 };
        TreeNode root4 = constructFromPrePost(preorder4, postorder4);
        System.out.print("Test 4 Preorder: ");
        printPreorder(root4); // Expected: 1 2 3
        System.out.println();

        // Test Case 5: Balanced tree
        // 1
        // / \
        // 2 3
        int[] preorder5 = { 1, 2, 3 };
        int[] postorder5 = { 2, 3, 1 };
        TreeNode root5 = constructFromPrePost(preorder5, postorder5);
        System.out.print("Test 5 Preorder: ");
        printPreorder(root5); // Expected: 1 2 3
        System.out.println();
    }
}
