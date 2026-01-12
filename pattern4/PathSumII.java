package pattern4;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        findPaths(root, targetSum, resultList, new ArrayList<>());
        return resultList;
    }

    private void findPaths(TreeNode root, int remaning, List<List<Integer>> resultList, List<Integer> results) {
        if (root == null)
            return;
        results.add(root.val);
        boolean isLeaf = (root.left == null && root.right == null);
        boolean sumMatched = (remaning == root.val);
        if (isLeaf && sumMatched) {
            resultList.add(new ArrayList<>(results));
        }
        findPaths(root.left, remaning - root.val, resultList, results);
        findPaths(root.right, remaning - root.val, resultList, results);
        results.remove(results.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII solution = new PathSumII();

        // Test 1: Multiple valid paths
        /*
         * 5
         * / \
         * 4 8
         * / / \
         * 11 13 4
         * / \ / \
         * 7 2 5 1
         */
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(8);
        t1.left.left = new TreeNode(11);
        t1.left.left.left = new TreeNode(7);
        t1.left.left.right = new TreeNode(2);
        t1.right.left = new TreeNode(13);
        t1.right.right = new TreeNode(4);
        t1.right.right.left = new TreeNode(5);
        t1.right.right.right = new TreeNode(1);

        System.out.println("Test 1 (target=22): " + solution.pathSum(t1, 22));
        // Expected: [[5,4,11,2], [5,8,4,5]]

        // Test 2: Simple tree, one path
        /*
         * 1
         * / \
         * 2 3
         */
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        System.out.println("Test 2 (target=3): " + solution.pathSum(t2, 3));
        // Expected: [[1,2]]

        System.out.println("Test 3 (target=4): " + solution.pathSum(t2, 4));
        // Expected: [[1,3]]

        // Test 3: No valid path
        System.out.println("Test 4 (target=10): " + solution.pathSum(t2, 10));
        // Expected: []

        // Test 4: Empty tree
        System.out.println("Test 5 (null): " + solution.pathSum(null, 0));
        // Expected: []

        // Test 5: Single node - matches
        TreeNode t5 = new TreeNode(5);
        System.out.println("Test 6 (single=5, target=5): " + solution.pathSum(t5, 5));
        // Expected: [[5]]

        // Test 6: Single node - no match
        System.out.println("Test 7 (single=5, target=1): " + solution.pathSum(t5, 1));
        // Expected: []

        // Test 7: Negative values
        /*
         * -2
         * / \
         * -3 2
         */
        TreeNode t7 = new TreeNode(-2);
        t7.left = new TreeNode(-3);
        t7.right = new TreeNode(2);

        System.out.println("Test 8 (negative, target=-5): " + solution.pathSum(t7, -5));
        // Expected: [[-2,-3]]

        System.out.println("Test 9 (negative, target=0): " + solution.pathSum(t7, 0));
        // Expected: [[-2,2]]
    }
}
