public class PowerOfFour {
	public static void main(String[] args) {
		int num = 17;
		System.out.print(isPowerOfFour(num) + "\n");
	}
	public static boolean isPowerOfFour(int num) {
		return num > 0 && (num & num - 1) == 0 && (num & 0x55555555) != 0;
	}
}