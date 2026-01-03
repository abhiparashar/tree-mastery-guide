package pattern1.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepestLevelSum {
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

    // public int deepestLeavesSum(TreeNode root) {
    // List<List<Integer>> result = new ArrayList<>();
    // int sum = 0;
    // if (root == null) {
    // return sum;
    // }
    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.offer(root);
    // while (!queue.isEmpty()) {
    // int levelSize = queue.size();
    // List<Integer> list = new ArrayList<>();
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
    // List<Integer> lastArr = result.get(0);
    // for (int i = 0; i < lastArr.size(); i++) {
    // sum = sum + lastArr.get(i);
    // }
    // return sum;
    // }

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            sum = 0; // Reset for each level!
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return sum; // Last level's sum
    }

    public static void main(String[] args) {
        DeepestLevelSum solution = new DeepestLevelSum();
        // Test 1:
        // 1
        // / \
        // 2 3
        // / \ \
        // 4 5 6
        // / \
        // 7 8
        // Deepest: [7, 8], Sum = 15
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.left = new TreeNode(4);
        test1.left.right = new TreeNode(5);
        test1.right.right = new TreeNode(6);
        test1.left.left.left = new TreeNode(7);
        test1.right.right.right = new TreeNode(8);
        System.out.println("Test 1: " + (solution.deepestLeavesSum(test1) == 15
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 2:
        // 1
        // / \
        // 2 3
        // /
        // 4
        // / \
        // 5 6
        // Deepest: [5, 6], Sum = 11
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.left.left.left = new TreeNode(5);
        test2.left.left.right = new TreeNode(6);
        System.out.println("Test 2: " + (solution.deepestLeavesSum(test2) == 11
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 3: Single node
        TreeNode test3 = new TreeNode(42);
        System.out.println("Test 3: " + (solution.deepestLeavesSum(test3) == 42
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 4: Two levels
        // 1
        // / \
        // 2 3
        // Deepest: [2, 3], Sum = 5
        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(2);
        test4.right = new TreeNode(3);
        System.out.println("Test 4: " + (solution.deepestLeavesSum(test4) == 5
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 5: Unbalanced
        // 1
        // /
        // 2
        // /
        // 3
        // Deepest: [3], Sum = 3
        TreeNode test5 = new TreeNode(1);
        test5.left = new TreeNode(2);
        test5.left.left = new TreeNode(3);
        System.out.println("Test 5: " + (solution.deepestLeavesSum(test5) == 3
                ? "PASS ✓"
                : "FAIL ✗"));
    }
}
