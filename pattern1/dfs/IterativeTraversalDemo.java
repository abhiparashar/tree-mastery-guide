package pattern1.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class IterativeTraversalDemo {
    public static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return result;
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null)
            return nodes;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nodes.add(curr.val);
            curr = curr.right;
        }
        return nodes;
    }

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode peek = stack.peek();
            if (peek.right == null || peek.right == lastVisited) {
                stack.pop();
                nodes.add(peek.val);
                lastVisited = peek;
            } else {
                curr = peek.right;
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \
         * 4 5
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Preorder:  " + preorder(root));
        System.out.println("Inorder:   " + inorder(root));
        System.out.println("Postorder: " + postorder(root));
    }
}