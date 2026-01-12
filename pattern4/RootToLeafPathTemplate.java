package pattern4;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathTemplate {

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

    public List<List<Integer>> findAllPaths(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findPaths(root, target, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode root, int remaining, List<Integer> currentPath, List<List<Integer>> resultList) {
        if (root == null)
            return;

        currentPath.add(root.val);

        boolean isleaf = (root.left == null && root.right == null);

        boolean sumMatches = (remaining == root.val);

        if (isleaf && sumMatches) {
            resultList.add(new ArrayList<>(currentPath));
        }

        findPaths(root.left, remaining - root.val, currentPath, resultList);
        findPaths(root.right, remaining - root.val, currentPath, resultList);

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        RootToLeafPathTemplate solution = new RootToLeafPathTemplate();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> paths = solution.findAllPaths(root, 22);
        System.out.println("Paths with sum 22:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
        // Output: [5, 4, 11, 2]
        // [5, 8, 4, 5]

        // Simple test
        TreeNode simple = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("\nPaths with sum 3: " + solution.findAllPaths(simple, 3));
        // Output: [[1, 2]]
    }
}
