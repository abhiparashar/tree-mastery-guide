package pattern6;

public class SameTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {

        return sameTree(root1, root2);
    }

    public boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 == null || root1 == null && root2 != null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        SameTree solution = new SameTree();

        // Test case 1: [1,2,3], [1,2,3]
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(p1, q1)); // Expected: true

        // Test case 2: [1,2], [1,null,2]
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution.isSameTree(p2, q2)); // Expected: false

        // Test case 3: [1,2,1], [1,1,2]
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSameTree(p3, q3)); // Expected: false

        // Test case 4: null, null
        System.out.println(solution.isSameTree(null, null)); // Expected: true

    }
}
