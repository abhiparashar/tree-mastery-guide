package pattern1.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRight {
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

    public static void printNextPointers(Node root) {
        if (root == null)
            return;
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            System.out.print("Level: ");
            while (current != null) {
                System.out.print(current.val + " → ");
                current = current.next;
            }
            System.out.println("null");
            levelStart = levelStart.left;
        }
        System.out.println();
    }

    public static Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (i < levelSize - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // Test Case 1: Perfect binary tree
        // 1 → null
        // / \
        // 2 → 3 → null
        // / \ / \
        // 4→5→6→7 → null
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        connect(root1);
        printNextPointers(root1);
        // Expected:
        // Level 0: 1 → null
        // Level 1: 2 → 3 → null
        // Level 2: 4 → 5 → 6 → 7 → null

        // Test Case 2: Single node
        Node root2 = new Node(1);
        connect(root2);
        printNextPointers(root2);
        // Expected:
        // Level 0: 1 → null

        // Test Case 3: Empty tree
        connect(null);
        // Expected: (nothing)
    }
}
