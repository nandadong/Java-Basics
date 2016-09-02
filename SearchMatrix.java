public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return false;
        for (int i = 0; i < m; i ++) {
            if (target <= matrix[i][n - 1]) {
                for (int j = 0; j < n; j ++) {
                    if (target == matrix[i][j]) return true;
                }
            }
        }
        return false;
    }
}