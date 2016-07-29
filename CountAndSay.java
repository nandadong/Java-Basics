public class CountAndSay {
	public static void main(String[] args) {
		int n = 6;
		System.out.print(countAndSay(n) + "\n");
	}
	public static String countAndSay(int n) {
		String s = "1", temp = "";

		while (n > 1) {
			int count = 1;
			for (int i = 0; i < s.length(); i++) {
				if (i + 1 < s.length()) {
					if (s.charAt(i) == s.charAt(i+1)) {
						count ++;
					} else {
						temp += String.valueOf(count) + s.charAt(i);
						count = 1;
					}
				} else {
					temp += String.valueOf(count) + s.charAt(i);
				}
			}
			s = temp;
			temp = "";
			n --;
		}
		return s;
	}
}