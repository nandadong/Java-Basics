import java.util.*;
public class GrayCode {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(grayCode(n));
	}
	public static List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		int num = (int) Math.pow(2, n);
		for (int i = 0; i < num; i ++) {
			result.add(i ^ (i >> 1));
		}
		return result;
	}
}