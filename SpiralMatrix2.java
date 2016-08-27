public class SpiralMatrix2 {
	public static void main(String[] args) {
		int n = 6;
		int[][] matrix = generateMatrix(n);
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int i = 0, j = 0;
		for (int k = 1; k <= n * n; k ++) {
			matrix[i][j] = k;
			// System.out.println(i + " " + j);
			if ((i == 0 || matrix[i - 1][j] != 0) && j + 1 < n && matrix[i][j + 1] == 0) j ++;
			else if ((j == n - 1 || matrix[i][j + 1] != 0) && i + 1 < n && matrix[i + 1][j] == 0) i ++;
			else if ((i == n - 1 || matrix[i + 1][j] != 0) && j > 0 && matrix[i][j - 1] == 0) j --;
			else i --;
		}
		return matrix;
	}
}