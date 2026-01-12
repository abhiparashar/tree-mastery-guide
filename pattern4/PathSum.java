package pattern4;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
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

    public boolean hasPathSum(TreeNode root, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return false;
        }
        findPaths(root, target, resultList, new ArrayList<>());
        return resultList.size() == 0 ? false : true;
    }

    private void findPaths(TreeNode root, int remaining, List<List<Integer>> resultList, List<Integer> results) {
        if (root == null)
            return;

        results.add(root.val);

        boolean hasLeaf = (root.left == null && root.right == null);
        boolean sameSum = (remaining == root.val);
        if (hasLeaf && sameSum) {
            resultList.add(new ArrayList<>(results));
        }
        findPaths(root.left, remaining - root.val, resultList, results);
        findPaths(root.right, remaining - root.val, resultList, results);
        results.remove(results.size() - 1);
    }

    public static void main(String[] args) {
        PathSum solution = new PathSum();

        // Test 1: Path exists
        /*
         * 5
         * / \
         * 4 8
         * / / \
         * 11 13 4
         * / \ \
         * 7 2 1
         */
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(8);
        t1.left.left = new TreeNode(11);
        t1.left.left.left = new TreeNode(7);
        t1.left.left.right = new TreeNode(2);
        t1.right.left = new TreeNode(13);
        t1.right.right = new TreeNode(4);
        t1.right.right.right = new TreeNode(1);

        // System.out.println("Test 1 (target=22): " + solution.hasPathSum(t1, 22)); //
        // true
        System.out.println("Test 2 (target=27): " + solution.hasPathSum(t1, 27)); // true (5→8→13+1? no, 5→8→4→1=18...
                                                                                  // let me recalc)

        // Test 2: Simple tree, no path
        /*
         * 1
         * / \
         * 2 3
         */
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        System.out.println("Test 3 (target=5): " + solution.hasPathSum(t2, 5)); // false
        System.out.println("Test 4 (target=3): " + solution.hasPathSum(t2, 3)); // true (1→2)
        System.out.println("Test 5 (target=4): " + solution.hasPathSum(t2, 4)); // true (1→3)

        // Test 3: Empty tree
        System.out.println("Test 6 (null, 0): " + solution.hasPathSum(null, 0)); // false

        // Test 4: Single node
        TreeNode t4 = new TreeNode(5);
        System.out.println("Test 7 (single=5, target=5): " + solution.hasPathSum(t4, 5)); // true
        System.out.println("Test 8 (single=5, target=1): " + solution.hasPathSum(t4, 1)); // false

        // Test 5: Negative values
        /*
         * -2
         * \
         * -3
         */
        TreeNode t5 = new TreeNode(-2);
        t5.right = new TreeNode(-3);
        System.out.println("Test 9 (negative, target=-5): " + solution.hasPathSum(t5, -5)); // true
    }
}
