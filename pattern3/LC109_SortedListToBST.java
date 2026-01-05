package pattern3;

public class LC109_SortedListToBST {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Helper: Build linked list from array
    private ListNode buildList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: Print tree structure
    private void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null)
            return;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);
        printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now at middle
        // Disconnect left half
        prev.next = null;

        TreeNode root = new TreeNode(slow.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    public static void main(String[] args) {
        LC109_SortedListToBST solution = new LC109_SortedListToBST();

        // Test Case 1
        int[] arr1 = { -10, -3, 0, 5, 9 };
        ListNode head1 = solution.buildList(arr1);
        TreeNode result1 = solution.sortedListToBST(head1);
        System.out.println("Test 1: [-10,-3,0,5,9]");
        solution.printTree(result1, "", false);

        // Test Case 2
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
        ListNode head2 = solution.buildList(arr2);
        TreeNode result2 = solution.sortedListToBST(head2);
        System.out.println("\nTest 2: [1,2,3,4,5,6,7]");
        solution.printTree(result2, "", false);

        // Test Case 3: Empty list
        TreeNode result3 = solution.sortedListToBST(null);
        System.out.println("\nTest 3: [] -> " + result3);

        // Test Case 4: Single element
        int[] arr4 = { 1 };
        ListNode head4 = solution.buildList(arr4);
        TreeNode result4 = solution.sortedListToBST(head4);
        System.out.println("\nTest 4: [1] -> root = " + (result4 != null ? result4.val : "null"));
    }
}