public class VersionControl {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(firstBadVersion(n));
	}
	public static int firstBadVersion(int n) {
		int start = 1, end = n;
		while (start + 1 < end) {
			int mid = start + (end - start)/2; //in case of overflow
			if (isBadVersion(mid)) end = mid;
			else start = mid;
		}
		return isBadVersion(start) ? start : end;
		
	}
	public static boolean isBadVersion(int version) {
		if (version >= 4) {
			return true;
		}
		return false;
	}
}