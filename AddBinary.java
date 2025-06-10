public class AddBinary {
	public static void main(String[] args) {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		// String a = "111", b = "101";
		System.out.print(addBinary(a, b) + "\n");
	}
	public static String addBinary(String a, String b) {
		String makeup = "";
		for (int i = 0; i < Math.abs(a.length()-b.length()); i++) {
			makeup += 0;
		}
		if (a.length() < b.length()) {
			a = makeup + a;
		} else {
			b = makeup + b;
		}
		String result = "";
		int carry = 0;
		for (int i = a.length()-1; i >= 0; i--) {
			int x = a.charAt(i) - '0';
			int y = b.charAt(i) - '0';
			int sum = x ^ y ^ carry;
			carry = (x + y + carry) / 2;
			result = sum + result;
		}
		if (carry == 1) {
			result = carry + result;
		}
		return result;
	}
}
