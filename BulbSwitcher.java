public class BulbSwitcher {
	public static void main(String[] args) {
		int n = 9999999;
		System.out.println(bulbSwitch(n));
	}
	public static int bulbSwitch(int n) {
		// int[] status = new int[n];
		// for (int i = 0; i < n; i++) {
		// 	for (int j = 0; j < n; j++) {
		// 		if ((i + 1) * (j + 1) <= n) status[(i + 1) * (j + 1) - 1] ^= 1;
		// 		else break;
		// 	}
		// }
		// int count = 0;
		// for (int s : status) count += s;
		// return count;
		return (int)Math.sqrt(n);
	}
}