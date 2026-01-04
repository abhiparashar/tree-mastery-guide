package pattern1.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsCousinsOfTree {
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

    // public boolean isCousins(TreeNode root, int val1, int val2) {
    // // 1. Check depth
    // if (root == null) {
    // return true;
    // }
    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.offer(root);
    // int depth1 = 0;
    // int depth2 = 0;
    // boolean isDepthFound1 = false;
    // boolean isDepthFound2 = false;
    // int leftParentVal = -1;
    // int rightparentVal = -1;
    // while (!queue.isEmpty()) {
    // int levelSize = queue.size();
    // for (int i = 0; i < levelSize; i++) {
    // TreeNode node = queue.poll();
    // if (node.val == val1) {
    // isDepthFound1 = true;
    // }
    // if (node.val == val2) {
    // isDepthFound2 = true;
    // }
    // if (node.left != null) {
    // if (!isDepthFound1) {
    // leftParentVal = node.val;
    // }
    // queue.offer(node.left);
    // }
    // if (node.right != null) {
    // if (!isDepthFound2) {
    // rightparentVal = node.val;
    // }
    // queue.offer(node.right);
    // }
    // }
    // if (!isDepthFound1) {
    // depth1++;
    // }
    // if (!isDepthFound2) {
    // depth2++;
    // }
    // }
    // if (depth1 == depth2 && leftParentVal != rightparentVal) {
    // return true;
    // }
    // return false;
    // }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int xDepth = -1, yDepth = -1;
        TreeNode xParent = null, yParent = null;
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Check LEFT child
                if (node.left != null) {
                    if (node.left.val == x) {
                        xDepth = depth + 1;
                        xParent = node;
                    }
                    if (node.left.val == y) {
                        yDepth = depth + 1;
                        yParent = node;
                    }
                    queue.offer(node.left);
                }

                // Check RIGHT child
                if (node.right != null) {
                    if (node.right.val == x) {
                        xDepth = depth + 1;
                        xParent = node;
                    }
                    if (node.right.val == y) {
                        yDepth = depth + 1;
                        yParent = node;
                    }
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return (xDepth == yDepth) && (xParent != yParent);
    }

    public static void main(String[] args) {
        IsCousinsOfTree solution = new IsCousinsOfTree();
        // Test 1: Different depths → NOT cousins
        // 1
        // / \
        // 2 3
        // /
        // 4
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.left = new TreeNode(4);
        System.out.println("Test 1: " + (solution.isCousins(test1, 4, 3) == false
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 2: Same depth, different parents → ARE cousins
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.right.right = new TreeNode(5);
        System.out.println("Test 2: " + (solution.isCousins(test2, 4, 5) == true
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 3: Same depth, SAME parent (siblings) → NOT cousins
        // 1
        // / \
        // 2 3
        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        test3.right = new TreeNode(3);
        System.out.println("Test 3: " + (solution.isCousins(test3, 2, 3) == false
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 4: Deep cousins → ARE cousins
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        // / \
        // 6 7
        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(2);
        test4.right = new TreeNode(3);
        test4.left.left = new TreeNode(4);
        test4.right.right = new TreeNode(5);
        test4.left.left.left = new TreeNode(6);
        test4.right.right.right = new TreeNode(7);
        System.out.println("Test 4: " + (solution.isCousins(test4, 6, 7) == true
                ? "PASS ✓"
                : "FAIL ✗"));

        // Test 5: Siblings at depth 2 → NOT cousins
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        TreeNode test5 = new TreeNode(1);
        test5.left = new TreeNode(2);
        test5.right = new TreeNode(3);
        test5.left.left = new TreeNode(4);
        test5.left.right = new TreeNode(5);
        System.out.println("Test 5: " + (solution.isCousins(test5, 4, 5) == false
                ? "PASS ✓"
                : "FAIL ✗"));
    }
}
