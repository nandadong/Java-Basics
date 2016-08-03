public class ZigZag {
	public static void main(String[] args) {
		String text = "PAYPALISHIRING";
		int nRows = 5;
		System.out.print(convert(text, nRows) + "\n");
	}
	public static String convert(String text, int nRows) {
		if (nRows == 1) {
			return text;
		}
		int div = nRows + nRows - 2;
		String result = "";
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < text.length(); j++) {
				if (j % div == i || j % div == div - i) {
					result += text.charAt(j);
				}
			}
		}
		return result;
	}
}