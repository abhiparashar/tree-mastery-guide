package pattern4;

import java.util.ArrayDeque;
import java.util.Deque;

public class GoodNodes_custom {
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

    public int count;

    public int goodNodes(TreeNode root) {
        count = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        totalGoodNodes(root, stack);
        return count;
    }

    private void totalGoodNodes(TreeNode root, Deque<Integer> stack) {
        if (root == null)
            return;

        boolean pushed = false;
        Integer oldValue = null;

        if (stack.isEmpty()) {
            stack.push(root.val);
            count++;
            pushed = true;
        } else {
            if (stack.peek() <= root.val) {
                oldValue = stack.pop();
                stack.push(root.val);
                count++;
                pushed = true;
            }
        }

        totalGoodNodes(root.left, stack);
        totalGoodNodes(root.right, stack);

        if (pushed) {
            stack.pop();
            if (oldValue != null) {
                stack.push(oldValue); // ← Old value RESTORE karo!
            }
        }
    }

    public static void main(String[] args) {
        GoodNodes_custom solution = new GoodNodes_custom();

        // Test Case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);
        System.out.println("Test 1: " + solution.goodNodes(root1)); // Expected: 4

        // Test Case 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        System.out.println("Test 2: " + solution.goodNodes(root2)); // Expected: 3

        // Test Case 3: Single node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3: " + solution.goodNodes(root3)); // Expected: 1

        // Test Case 4: All increasing path
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.left.left = new TreeNode(4);
        System.out.println("Test 4: " + solution.goodNodes(root4)); // Expected: 4

        // Test Case 5: All same values
        TreeNode root5 = new TreeNode(5);
        root5.left = new TreeNode(5);
        root5.right = new TreeNode(5);
        root5.left.left = new TreeNode(5);
        System.out.println("Test 5: " + solution.goodNodes(root5)); // Expected: 4

        // Test Case 6: All decreasing
        TreeNode root6 = new TreeNode(9);
        root6.left = new TreeNode(8);
        root6.right = new TreeNode(7);
        root6.left.left = new TreeNode(6);
        System.out.println("Test 6: " + solution.goodNodes(root6)); // Expected: 1

        // Test Case 7: Negative values
        TreeNode root7 = new TreeNode(-1);
        root7.left = new TreeNode(-2);
        root7.right = new TreeNode(-3);
        root7.left.left = new TreeNode(-1);
        System.out.println("Test 7: " + solution.goodNodes(root7)); // Expected: 3
    }
}
