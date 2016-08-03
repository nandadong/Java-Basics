public class ExcelII {
	public static void main(String[] args) {
		int n = 28;
		System.out.println(convertToTitle(n));
	}
	public static String convertToTitle(int n) {
		String s = "";
		while (n > 0) {
			n --;
			char c = Character.toChars(n % 26 + 'A')[0];
			s = c + s;
			n = n / 26;
		}
		return s;
	}
}