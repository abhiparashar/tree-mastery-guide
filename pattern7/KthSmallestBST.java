import java.util.Stack;

public class KthSmallestBST {
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

    public int kthSmallest(TreeNode root, int val) {
        Stack<Integer> stack = new Stack<>();
        if (root == null) {
            return 0;
        }
        findkthsmallestVal(root, val, stack);
        int k = stack.size() - val;
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        return stack.peek();
    }

    private void findkthsmallestVal(TreeNode root, int val, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        findkthsmallestVal(root.left, val, stack);
        stack.push(root.val);
        findkthsmallestVal(root.right, val, stack);
    }

    public static void main(String[] args) {
        KthSmallestBST solution = new KthSmallestBST();

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

        // Test 1: k=1 (smallest)
        int result1 = solution.kthSmallest(root, 1);
        System.out.println("Test 1 - k=1: " + result1 + " | Expected: 1");

        // Test 2: k=2
        int result2 = solution.kthSmallest(root, 2);
        System.out.println("Test 2 - k=2: " + result2 + " | Expected: 2");

        // Test 3: k=3
        int result3 = solution.kthSmallest(root, 3);
        System.out.println("Test 3 - k=3: " + result3 + " | Expected: 3");

        // Test 4: k=4
        int result4 = solution.kthSmallest(root, 4);
        System.out.println("Test 4 - k=4: " + result4 + " | Expected: 4");

        // Test 5: k=5 (largest)
        int result5 = solution.kthSmallest(root, 5);
        System.out.println("Test 5 - k=5: " + result5 + " | Expected: 7");

    }
}
