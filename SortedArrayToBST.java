import java.util.*;
public class SortedArrayToBST {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(sortedArrayToBST(nums).right.left.left.val);
	}
	public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if (nums.length == 0) return root;

        root = new TreeNode(nums[nums.length / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return root;
    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}