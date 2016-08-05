public class VersionNum {
	public static void main(String[] args) {
		String version1 = "13.13";
		String version2 = "13.13.0";
		System.out.println(compareVersion(version1, version2));
	}
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
		int i = 0;
		for ( ; i < Math.min(v1.length, v2.length); i++) {
			if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[i])) return 1;
			else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) return -1;
		}
		
		String[] tmp = i == v1.length ? v2 : v1;
		for ( ; i < tmp.length; i++) {
			if (Integer.valueOf(tmp[i]) != 0) return i < v1.length ? 1 : -1;
		}
		return 0;
	}
}