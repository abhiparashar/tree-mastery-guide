package pattern1.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
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

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(sum / levelSize);
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

        System.out.println("Test 1: " + averageOfLevels(root1));
        // Expected: [3.0, 14.5, 11.0]
        // Level 0: 3/1 = 3.0
        // Level 1: (9+20)/2 = 14.5
        // Level 2: (15+7)/2 = 11.0

        // Test Case 2: Single node
        TreeNode root2 = new TreeNode(5);
        System.out.println("Test 2: " + averageOfLevels(root2));
        // Expected: [5.0]

        // Test Case 3: Left skewed
        // 1
        // /
        // 2
        // /
        // 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        System.out.println("Test 3: " + averageOfLevels(root3));
        // Expected: [1.0, 2.0, 3.0]

        // Test Case 4: Complete tree
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        System.out.println("Test 4: " + averageOfLevels(root4));
        // Expected: [1.0, 2.5, 4.5]
    }
}
