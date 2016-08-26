import java.util.*;
public class RightSideView {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		System.out.println(rightSideView(root));
	}
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		rightSideViewHelper(root, list, 0);
		return list;
	}
	private static void rightSideViewHelper(TreeNode root, List<Integer> list, int depth) {
		if (root == null) return;
		if (list.size() == depth) list.add(root.val);
		rightSideViewHelper(root.right, list, depth + 1);
		rightSideViewHelper(root.left, list, depth + 1);
	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}