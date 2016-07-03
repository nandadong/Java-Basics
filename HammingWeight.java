public class HammingWeight {
	public static void main(String[] args) {
		int n = 11;
		System.out.print(hammingWeight(n) + "\n");
	}

	public static int hammingWeight(int n) {
		char[] arr = Integer.toBinaryString(n).toCharArray();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '1') {
				count++;
			}
		}
		return count;
	}
}