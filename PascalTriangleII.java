import java.util.*;
public class PascalTriangleII {
	public static void main(String[] args) {
		int k = 4;
		System.out.print(getRow(k) + "\n");
	}
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> last = new ArrayList<Integer>();
		last.add(1);
		if (rowIndex == 0) {
			return  last;
		}
		last.add(1);
		if (rowIndex == 1) {
			return last;
		}
		List<Integer> current = new ArrayList<Integer>();
		int n = 1;
		while (n < rowIndex) {
			current.clear();
			current.add(1);
			for (int i = 0; i < n; i++) {
				current.add(last.get(i) + last.get(i+1));
			}
			current.add(1);
			last = new ArrayList<Integer>(current);
			n++;
		}
		return current;
	}
}