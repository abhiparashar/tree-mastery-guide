package pattern1.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            leftToRight = !leftToRight;
            result.add(list);
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

        System.out.println("Test 1: " + zigzagLevelOrder(root1));
        // Expected: [[3], [20, 9], [15, 7]]

        // Test Case 2: Single node
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test 2: " + zigzagLevelOrder(root2));
        // Expected: [[1]]

        // Test Case 3: Empty tree
        System.out.println("Test 3: " + zigzagLevelOrder(null));
        // Expected: []

        // Test Case 4: Complete tree (4 levels)
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7
        // /
        // 8
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(7);
        root4.left.left.left = new TreeNode(8);
        System.out.println("Test 4: " + zigzagLevelOrder(root4));
        // Expected: [[1], [3, 2], [4, 5, 6, 7], [8]]

        // Test Case 5: Right skewed
        // 1
        // \
        // 2
        // \
        // 3
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);
        System.out.println("Test 5: " + zigzagLevelOrder(root5));
        // Expected: [[1], [2], [3]]
    }
}
