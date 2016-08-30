import java.util.*;
public class MinPathSum {
	public static void main(String[] args) {
		int[][] grid = {
			{ 1, 10,  1,  1, 1},
			{ 1,  1,  1, 10, 1},
			{10, 10, 10, 10, 1},
			{10, 10, 10, 10, 1},
			{10, 10, 10, 10, 1}
		};
		System.out.println(minPathSum(grid));	
	}
	public static int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i ++) {
			for (int j =0; j < n; j ++) {
				if (i == 0 && j == 0) ;
				else if (i == 0) grid[i][j] += grid[i][j - 1];
				else if (j == 0) grid[i][j] += grid[i - 1][j];
				else grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
			}
		}
		return grid[m - 1][n - 1];
	}
	
}