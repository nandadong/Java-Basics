public class IsSameTree {
	public static void main(String[] args) {
		// TreeNode p = null;
		// TreeNode q = null;
		TreeNode p = new TreeNode(2);
		p.left = new TreeNode(7);
		p.right = new TreeNode(5);
		p.left.left = new TreeNode(2);
		p.left.right = new TreeNode(6);
		p.left.right.left = new TreeNode(5);
		p.left.right.right = new TreeNode(11);

		TreeNode q = new TreeNode(2);
		q.left = new TreeNode(7);
		q.right = new TreeNode(5);
		q.left.left = new TreeNode(2);
		q.left.right = new TreeNode(6);
		q.left.right.left = new TreeNode(5);
		q.left.right.right = new TreeNode(11);		

		System.out.print(isSameTree(p, q) + "\n");
	}
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null && q != null || p != null && q == null) {
			return false;
		}
		if (p.val == q.val) {
			return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
		}
		return false;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}