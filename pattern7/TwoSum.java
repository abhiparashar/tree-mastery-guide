import java.util.HashSet;

public class TwoSum {
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

    public boolean findTarget(TreeNode root, int val) {
        HashSet<Integer> set = new HashSet<>();
        boolean ans = find(root, val, set);
        return ans;
    }

    private boolean find(TreeNode root, int target, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(target - root.val)) {
            return true;
        }

        set.add(root.val);

        return find(root.left, target, set) || find(root.right, target, set);
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        // Test Case 1: [5,3,6,2,4,null,7], k = 9
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);
        System.out.println("Test 1: " + sol.findTarget(root1, 9)); // Expected: true

        // Test Case 2: [5,3,6,2,4,null,7], k = 28
        System.out.println("Test 2: " + sol.findTarget(root1, 28)); // Expected: false

        // Test Case 3: [2,1,3], k = 4
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println("Test 3: " + sol.findTarget(root2, 4)); // Expected: true

        // Test Case 4: [2,1,3], k = 1
        System.out.println("Test 4: " + sol.findTarget(root2, 1)); // Expected: false

        // Test Case 5: [2,1,3], k = 3
        System.out.println("Test 5: " + sol.findTarget(root2, 3)); // Expected: true

        // Test Case 6: Single node [1], k = 2
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 6: " + sol.findTarget(root3, 2)); // Expected: false

        // Test Case 7: [1,0,2], k = 2
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(0);
        root4.right = new TreeNode(2);
        System.out.println("Test 7: " + sol.findTarget(root4, 2)); // Expected: true
    }
}
