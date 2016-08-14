import java.util.*;
public class KthSmallest {
	public static void main(String[] args) {
		int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
		int k = 8;
		System.out.println(kthSmallest(matrix, k));
	}
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int[] array = new int[n * n];
		for (int i = 0; i < array.length; i++) {
			array[i] = matrix[i / n][i % n];
		}
		Arrays.sort(array);
		return array[k - 1];
	}
}