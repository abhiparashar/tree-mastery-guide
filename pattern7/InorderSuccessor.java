import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {
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

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> listOfNodes = inorderTraversal(root, list);
        for (int i = 0; i < listOfNodes.size() - 1; i++) {
            if (listOfNodes.get(i).val == p.val) {
                return listOfNodes.get(i + 1);
            }
        }
        return ans;
    }

    private List<TreeNode> inorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left, list);
        list.add(root);
        inorderTraversal(root.right, list);
        return list;
    }

    public static void main(String[] args) {
        InorderSuccessor sol = new InorderSuccessor();

        // Test Case 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(1);

        TreeNode result1 = sol.inorderSuccessor(root1, root1.left); // p = 3
        System.out.println("Test 1: " + (result1 != null ? result1.val : "null"));
        // Expected: 4

        // // Test Case 2
        TreeNode result2 = sol.inorderSuccessor(root1, root1.right); // p = 6
        System.out.println("Test 2: " + (result2 != null ? result2.val : "null"));
        // Expected: null

        // // Test Case 3
        TreeNode result3 = sol.inorderSuccessor(root1, root1.left.left); // p = 2
        System.out.println("Test 3: " + (result3 != null ? result3.val : "null"));
        // Expected: 3

        // // Test Case 4
        TreeNode result4 = sol.inorderSuccessor(root1, root1.left.right); // p = 4
        System.out.println("Test 4: " + (result4 != null ? result4.val : "null"));
        // Expected: 5

        // // Test Case 5
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        TreeNode result5 = sol.inorderSuccessor(root2, root2.left); // p = 1
        System.out.println("Test 5: " + (result5 != null ? result5.val : "null"));
        // Expected: 2

    }
}
