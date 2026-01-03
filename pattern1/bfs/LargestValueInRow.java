package pattern1.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInRow {
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

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                maxNum = Math.max(maxNum, node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(maxNum);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Normal tree
        // 1
        // / \
        // 3 2
        // / \ \
        // 5 3 9
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);

        System.out.println("Test 1: " + largestValues(root1));
        // Expected: [1, 3, 9]

        // Test Case 2: Single node
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test 2: " + largestValues(root2));
        // Expected: [1]

        // Test Case 3: Empty tree
        System.out.println("Test 3: " + largestValues(null));
        // Expected: []

        // Test Case 4: All negative values
        // -1
        // / \
        // -2 -3
        TreeNode root4 = new TreeNode(-1);
        root4.left = new TreeNode(-2);
        root4.right = new TreeNode(-3);
        System.out.println("Test 4: " + largestValues(root4));
        // Expected: [-1, -2]

        // Test Case 5: Left skewed
        // 1
        // /
        // 5
        // /
        // 3
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(5);
        root5.left.left = new TreeNode(3);
        System.out.println("Test 5: " + largestValues(root5));
        // Expected: [1, 5, 3]
    }
}
