package pattern1.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class AddROW {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (level == depth - 1) {
                    TreeNode originalLeft = node.left;
                    TreeNode originalRight = node.right;
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = originalLeft;
                    node.right.right = originalRight;
                } else {
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
            }
            level++;
        }
        return root;
    }

    public static void main(String[] args) {
        AddROW solution = new AddROW();

        // Test 1: Add row at depth 2
        TreeNode test1 = buildTree(4, 2, 6, 3, 1, 5);
        TreeNode result1 = solution.addOneRow(test1, 1, 2);
        System.out.println("Test 1: " + (matchesExpected(result1,
                buildTree(4, 1, 1, 2, null, null, 6, 3, 1, null, null, null, null, 5))
                        ? "PASS ✓"
                        : "FAIL ✗"));

        // Test 2: Add row at depth 3
        TreeNode test2 = buildTree(4, 2, null, 3, 1);
        TreeNode result2 = solution.addOneRow(test2, 1, 3);
        System.out.println("Test 2: " + (matchesExpected(result2,
                buildTree(4, 2, null, 1, 1, null, null, 3, null, null, 1))
                        ? "PASS ✓"
                        : "FAIL ✗"));

        // Test 3: Add row at depth 1 (new root)
        TreeNode test3 = buildTree(4, 2, 6);
        TreeNode result3 = solution.addOneRow(test3, 1, 1);
        System.out.println("Test 3: " + (matchesExpected(result3,
                buildTree(1, 4, null, 2, 6))
                        ? "PASS ✓"
                        : "FAIL ✗"));

        // Test 4: Single node, add at depth 2
        TreeNode test4 = buildTree(1);
        TreeNode result4 = solution.addOneRow(test4, 2, 2);
        System.out.println("Test 4: " + (matchesExpected(result4,
                buildTree(1, 2, 2))
                        ? "PASS ✓"
                        : "FAIL ✗"));
    }

    // ============== FIXED buildTree ==============
    static TreeNode buildTree(Integer... vals) {
        if (vals.length == 0 || vals[0] == null)
            return null;
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < vals.length) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                i += 2;
                continue;
            }
            if (i < vals.length && vals[i] != null) {
                curr.left = new TreeNode(vals[i]);
                queue.offer(curr.left);
            } else {
                queue.offer(null);
            }
            i++;
            if (i < vals.length && vals[i] != null) {
                curr.right = new TreeNode(vals[i]);
                queue.offer(curr.right);
            } else {
                queue.offer(null);
            }
            i++;
        }
        return root;
    }

    static boolean matchesExpected(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        return a.val == b.val && matchesExpected(a.left, b.left)
                && matchesExpected(a.right, b.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}