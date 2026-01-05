package pattern3;

public class BSTFromArray {
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

    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.println(root.val + " ");
        printInorder(root.right);
    }

    public static TreeNode sortedArrayToBST(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        return buildBST(arr, 0, arr.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        // Test case 1: Normal sorted array
        int[] arr1 = { -10, -3, 0, 5, 9 };
        TreeNode root1 = sortedArrayToBST(arr1);
        printInorder(root1);
        System.out.println();

        // Test case 2: Single element
        int[] arr2 = { 1 };
        TreeNode root2 = sortedArrayToBST(arr2);
        printInorder(root2);
        System.out.println();

        // Test case 3: Empty array
        int[] arr3 = {};
        TreeNode root3 = sortedArrayToBST(arr3);
        printInorder(root3);
    }
}
