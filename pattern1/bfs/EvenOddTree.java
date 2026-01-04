package pattern1.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
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

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            if (level % 2 == 0) {
                int levelSize = queue.size();
                int prev = Integer.MIN_VALUE;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.val % 2 != 0 && node.val > prev) {
                        if (node.left != null)
                            queue.offer(node.left);
                        if (node.right != null)
                            queue.offer(node.right);
                    } else {
                        return false;
                    }
                    prev = node.val;
                }
            } else {
                int levelSize = queue.size();
                int prev = Integer.MAX_VALUE;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.val % 2 == 0 && node.val < prev) {
                        if (node.left != null)
                            queue.offer(node.left);
                        if (node.right != null)
                            queue.offer(node.right);
                    } else {
                        return false;
                    }
                    prev = node.val;
                }
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        EvenOddTree solution = new EvenOddTree();
        // Test 1: Valid Even-Odd tree
        // 1
        // / \
        // 10 4
        // /\ \
        // 3 7 9
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(10);
        test1.right = new TreeNode(4);
        test1.left.left = new TreeNode(3);
        test1.left.right = new TreeNode(7);
        test1.right.right = new TreeNode(9);
        System.out.println("Test 1: " + (solution.isEvenOddTree(test1) == true
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 2: Invalid - level 2 not strictly increasing (3, 3)
        // 5
        // / \
        // 4 2
        // /\ \
        // 3 3 7
        TreeNode test2 = new TreeNode(5);
        test2.left = new TreeNode(4);
        test2.right = new TreeNode(2);
        test2.left.left = new TreeNode(3);
        test2.left.right = new TreeNode(3);
        test2.right.right = new TreeNode(7);
        System.out.println("Test 2: " + (solution.isEvenOddTree(test2) == false
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 3: Invalid - root is even
        // 2
        // / \
        // 3 5
        TreeNode test3 = new TreeNode(2);
        test3.left = new TreeNode(3);
        test3.right = new TreeNode(5);
        System.out.println("Test 3: " + (solution.isEvenOddTree(test3) == false
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 4: Single node (odd) - valid
        TreeNode test4 = new TreeNode(1);
        System.out.println("Test 4: " + (solution.isEvenOddTree(test4) == true
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 5: Invalid - level 1 has odd value
        // 1
        // / \
        // 3 8
        TreeNode test5 = new TreeNode(1);
        test5.left = new TreeNode(3);
        test5.right = new TreeNode(8);
        System.out.println("Test 5: " + (solution.isEvenOddTree(test5) == false
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 6: Invalid - level 1 not decreasing (4, 6)
        // 1
        // / \
        // 4 6
        TreeNode test6 = new TreeNode(1);
        test6.left = new TreeNode(4);
        test6.right = new TreeNode(6);
        System.out.println("Test 6: " + (solution.isEvenOddTree(test6) == false
                ? "PASS ✓"
                : "FAIL ✗"));
    }
}
