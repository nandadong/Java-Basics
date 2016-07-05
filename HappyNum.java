import java.util.*;

public class HappyNum {
	public static void main(String[] args) {
		int n = 17;
		System.out.print(isHappy(n) + "\n");
	}

	public static boolean isHappy(int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		return isHappyHelper(n, hs);
	}
	public static boolean isHappyHelper(int n, HashSet<Integer> hs) {
		int dummy = 0;
		dummy += (n % 10)*(n % 10);
		while (n / 10 != 0) {
			n = n / 10;
			dummy += (n % 10)*(n % 10);
		}
		if (dummy == 1) {
			return true;
		}
		if (hs.contains(dummy)) {
			return false;
		}
		hs.add(dummy);
		return isHappyHelper(dummy, hs);
	}
}