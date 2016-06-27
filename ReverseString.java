public class ReverseString {
	public static void main(String[] args) {
		String s = "hello";
		String result = reverseString(s);
		System.out.println(result + "\n");
		// System.out.println(s.charAt(0) + "\n");
	}
	public static String reverseString(String s) {
		// String result = "";
		// for(int i = s.length() - 1; i >= 0 ; i--) {
		// 	result += s.charAt(i);
		// }
		// return result;

		/*** O(n/2) ***/
		char[] c = s.toCharArray();
		int l = s.length()/2;
		for(int i = 0; i < l; i++) {
			char temp = c[s.length() - 1 - i];
			c[s.length() - 1 - i] = c[i];
			c[i] = temp;
		}
		return new String(c);
	}
}
