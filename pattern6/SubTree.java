package pattern6;

public class SubTree {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        SubTree solution = new SubTree();

        // Test case 1: root = [3,4,5,1,2], subRoot = [4,1,2]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        root1.right = new TreeNode(5);
        TreeNode subRoot1 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSubtree(root1, subRoot1)); // Expected: true

        // Test case 2: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(2, new TreeNode(0), null);
        root2.right = new TreeNode(5);
        TreeNode subRoot2 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSubtree(root2, subRoot2)); // Expected: false

        // Test case 3: root = [1,1], subRoot = [1]
        TreeNode root3 = new TreeNode(1, new TreeNode(1), null);
        TreeNode subRoot3 = new TreeNode(1);
        System.out.println(solution.isSubtree(root3, subRoot3)); // Expected: true
    }
}
