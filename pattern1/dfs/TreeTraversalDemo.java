package pattern1.dfs;

public class TreeTraversalDemo {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.val + " ");
        inorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val + " ");
    }

    public static void main(String[] args) {
        // Create the tree:
        // 1
        // / \
        // 2 3
        // / \
        // 4 5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeTraversalDemo demo = new TreeTraversalDemo();

        System.out.println("PREORDER (Root-Left-Right):");
        demo.preorder(root);
        System.out.println();

        System.out.println("\nINORDER (Left-Root-Right):");
        demo.inorder(root);
        System.out.println();

        System.out.println("\nPOSTORDER (Left-Right-Root):");
        demo.postorder(root);
        System.out.println();
    }
}
