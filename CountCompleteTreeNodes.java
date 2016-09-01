public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int lh = height(root.left), rh = height(root.right);
        if (lh == rh) return (1 << lh) + countNodes(root.right);
        else return (1 << rh) + countNodes(root.left);
    }
    private int height(TreeNode root) {
        int h = 0;
        while (root != null) {
            h ++;
            root = root.left;
        }
        return h;
    }
}