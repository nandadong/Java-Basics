import java.util.*;
public class UniqPaths {
	public static void main(String[] args) {
		int m = 2, n = 3;
		System.out.println(uniquePaths(m, n));
	}
	
	public static int uniquePaths(int m, int n) {
		int[][] map = new int[m + 1][n + 1];
		return uniquePathsHelper(m, n, map);
	}
	private static int uniquePathsHelper(int m, int n, int[][] map) {
		if (map[m][n] != 0) {
			return map[m][n];
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		int num = uniquePathsHelper(m - 1, n, map) + uniquePathsHelper(m, n - 1, map);
		map[m][n] = num;
		if (m < map[0].length && n < map.length) {
			map[n][m] = num;
		}
		return num;
	}
}