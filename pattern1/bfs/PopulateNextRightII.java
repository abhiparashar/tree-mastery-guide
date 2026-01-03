package pattern1.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightII {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }

    // Helper to print next pointers
    public static void printNextPointers(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            System.out.print("Level: ");
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                System.out.print(node.val + " → ");
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            System.out.println("null");
        }
        System.out.println();
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (i < queue.size() - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

        // Test Case 1: Imperfect tree
        // 1 → null
        // / \
        // 2 → 3 → null
        // / \ \
        // 4→ 5 → 7 → null
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.right = new Node(7);

        connect(root1);
        printNextPointers(root1);
        // Expected:
        // Level 0: 1 → null
        // Level 1: 2 → 3 → null
        // Level 2: 4 → 5 → 7 → null

        // Test Case 2: Left skewed
        // 1 → null
        // /
        // 2 → null
        // /
        // 3 → null
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);

        connect(root2);
        printNextPointers(root2);
        // Expected:
        // Level 0: 1 → null
        // Level 1: 2 → null
        // Level 2: 3 → null

        // Test Case 3: Single node
        Node root3 = new Node(1);
        connect(root3);
        printNextPointers(root3);
        // Expected:
        // Level 0: 1 → null

        // Test Case 4: Empty tree
        connect(null);
        // Expected: (nothing)

        // Test Case 5: Sparse tree
        // 1 → null
        // / \
        // 2 3 → null
        // \ \
        // 5 7 → null
        Node root5 = new Node(1);
        root5.left = new Node(2);
        root5.right = new Node(3);
        root5.left.right = new Node(5);
        root5.right.right = new Node(7);

        connect(root5);
        printNextPointers(root5);
        // Expected:
        // Level 0: 1 → null
        // Level 1: 2 → 3 → null
        // Level 2: 5 → 7 → null
    }
}
