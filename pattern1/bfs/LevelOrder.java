package pattern1.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Normal tree
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println("Test 1: " + levelOrder(root1));
        // Expected: [[3], [9, 20], [15, 7]]

        // Test Case 2: Single node
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test 2: " + levelOrder(root2));
        // Expected: [[1]]

        // Test Case 3: Empty tree
        System.out.println("Test 3: " + levelOrder(null));
        // Expected: []

        // Test Case 4: Left skewed
        // 1
        // /
        // 2
        // /
        // 3
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        System.out.println("Test 4: " + levelOrder(root4));
        // Expected: [[1], [2], [3]]

        // Test Case 5: Complete binary tree
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);
        root5.right.left = new TreeNode(6);
        root5.right.right = new TreeNode(7);
        System.out.println("Test 5: " + levelOrder(root5));
        // Expected: [[1], [2, 3], [4, 5, 6, 7]]
    }
}
