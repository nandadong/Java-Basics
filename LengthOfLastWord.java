public class LengthOfLastWord {
	public static void main(String[] args) {
		String s = "   ";
		System.out.print(lengthOfLastWord(s) + "\n");
	}
	public static int lengthOfLastWord(String s) {
		String[] strarr = s.split(" ");
		if (strarr.length == 0) {
			return 0;
		}
		return strarr[strarr.length - 1].length();
	}
}