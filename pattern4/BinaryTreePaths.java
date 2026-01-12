package pattern4;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        buildPath(root, list, "");
        return list;
    }

    private void buildPath(TreeNode root, List<String> list, String path) {
        if (root == null)
            return;

        path = path.isEmpty() ? String.valueOf(root.val) : path + "->" + root.val;

        boolean isLeaf = root.left == null && root.right == null;

        if (isLeaf) {
            list.add(path);
            return;
        }

        buildPath(root.left, list, path);
        buildPath(root.right, list, path);
    }

    public static void main(String[] args) {
        BinaryTreePaths solution = new BinaryTreePaths();

        // Test Case 1: [1,2,3,null,5] → Expected: ["1->2->5", "1->3"]
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.right = new TreeNode(5);
        System.out.println("Test 1: " + solution.binaryTreePaths(test1));
        // Expected: ["1->2->5", "1->3"]

        // Test Case 2: [1] → Expected: ["1"]
        TreeNode test2 = new TreeNode(1);
        System.out.println("Test 2: " + solution.binaryTreePaths(test2));
        // Expected: ["1"]

        // Test Case 3: [1,2,3] → Expected: ["1->2", "1->3"]
        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        test3.right = new TreeNode(3);
        System.out.println("Test 3: " + solution.binaryTreePaths(test3));
        // Expected: ["1->2", "1->3"]
    }
}
