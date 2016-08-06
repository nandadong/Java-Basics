public class CountBits {
	public static void main(String[] args) {
		int num = 5;
		int[] arr = countBits(num);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.print("\n");
		// System.out.println(3 >> 1);
	}
	public static int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i = 0; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
		return f;
	}
}