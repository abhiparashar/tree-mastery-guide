package pattern1.dfs;

public class InvertBinaryTree {
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

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();

        // 4
        // / \
        // 2 7
        // / \ / \
        // 1 3 6 9
        TreeNode test1 = new TreeNode(4);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(7);
        test1.left.left = new TreeNode(1);
        test1.left.right = new TreeNode(3);
        test1.right.left = new TreeNode(6);
        test1.right.right = new TreeNode(9);
        System.out.print("Test 1 Before: ");
        printTree(test1);
        System.out.println();
        TreeNode result1 = solution.invertTree(test1);
        System.out.print("Test 1 After:  ");
        printTree(result1);
        System.out.println("(Expected: 4 7 9 6 2 3 1)");
        System.out.println();

        // 2
        // / \
        // 1 3
        TreeNode test2 = new TreeNode(2);
        test2.left = new TreeNode(1);
        test2.right = new TreeNode(3);
        System.out.print("Test 2 Before: ");
        printTree(test2);
        System.out.println();
        TreeNode result2 = solution.invertTree(test2);
        System.out.print("Test 2 After:  ");
        printTree(result2);
        System.out.println("(Expected: 2 3 1)");
        System.out.println();

        // 1
        // /
        // 2
        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        System.out.print("Test 3 Before: ");
        printTree(test3);
        System.out.println();
        TreeNode result3 = solution.invertTree(test3);
        System.out.print("Test 3 After:  ");
        printTree(result3);
        System.out.println("(Expected: 1 null 2)");
        System.out.println();

        // null
        TreeNode test4 = null;
        System.out.print("Test 4 Before: ");
        printTree(test4);
        System.out.println();
        TreeNode result4 = solution.invertTree(test4);
        System.out.print("Test 4 After:  ");
        printTree(result4);
        System.out.println("(Expected: null)");
        System.out.println();

        // 1
        TreeNode test5 = new TreeNode(1);
        System.out.print("Test 5 Before: ");
        printTree(test5);
        System.out.println();
        TreeNode result5 = solution.invertTree(test5);
        System.out.print("Test 5 After:  ");
        printTree(result5);
        System.out.println("(Expected: 1)");

    }
}
