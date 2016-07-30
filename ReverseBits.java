public class ReverseBits {
	public static void main(String[] args) {
		int n = 43261596 ;
		System.out.print(reverseBits(n) + "\n");
	}
	public static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int temp = n & 1;
			int reverseTemp = temp << (31-i);
			result = result | reverseTemp;
			n = n>>>1;
		}
		return result;
	}
}