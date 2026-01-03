package pattern1.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeft {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // public int findBottomLeftValue(TreeNode root) {
    // List<List<Integer>> result = new ArrayList<>();
    // int ans = -1;
    // if (root == null) {
    // return ans;
    // }
    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.offer(root);
    // while (!queue.isEmpty()) {
    // List<Integer> list = new ArrayList<>();
    // int levelSize = queue.size();
    // for (int i = 0; i < levelSize; i++) {
    // TreeNode node = queue.poll();
    // list.add(node.val);
    // if (node.left != null)
    // queue.offer(node.left);
    // if (node.right != null) {
    // queue.offer(node.right);
    // }
    // }
    // result.add(list);
    // }
    // Collections.reverse(result);
    // return result.getFirst().get(0);
    // }

    public int findBottomLeftValue(TreeNode root) {
        int bottomLeft = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    bottomLeft = node.val;
                }

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return bottomLeft;
    }

    public static void main(String[] args) {
        FindBottomLeft solution = new FindBottomLeft();
        // Test 1: Simple tree
        // 2
        // / \
        // 1 3
        // Last row: [1, 3], leftmost = 1
        TreeNode test1 = new TreeNode(2);
        test1.left = new TreeNode(1);
        test1.right = new TreeNode(3);
        System.out.println("Test 1: " + (solution.findBottomLeftValue(test1) == 1
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 2: Deeper tree, 7 is bottom-left
        // 1
        // / \
        // 2 3
        // / / \
        // 4 5 6
        // /
        // 7
        // Last row: [7], leftmost = 7
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.right.left = new TreeNode(5);
        test2.right.right = new TreeNode(6);
        test2.right.left.left = new TreeNode(7);
        System.out.println("Test 2: " + (solution.findBottomLeftValue(test2) == 7
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 3: Single node
        TreeNode test3 = new TreeNode(1);
        System.out.println("Test 3: " + (solution.findBottomLeftValue(test3) == 1
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 4: All left chain
        // 1
        // /
        // 2
        // /
        // 3
        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(2);
        test4.left.left = new TreeNode(3);
        System.out.println("Test 4: " + (solution.findBottomLeftValue(test4) == 3
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 5: All right chain
        // 1
        // \
        // 2
        // \
        // 3
        TreeNode test5 = new TreeNode(1);
        test5.right = new TreeNode(2);
        test5.right.right = new TreeNode(3);
        System.out.println("Test 5: " + (solution.findBottomLeftValue(test5) == 3
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 6: Two nodes at last level
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        // Last row: [4, 5], leftmost = 4
        TreeNode test6 = new TreeNode(1);
        test6.left = new TreeNode(2);
        test6.right = new TreeNode(3);
        test6.left.left = new TreeNode(4);
        test6.right.right = new TreeNode(5);
        System.out.println("Test 6: " + (solution.findBottomLeftValue(test6) == 4
                ? "PASS ✓"
                : "FAIL ✗"));
    }
}
