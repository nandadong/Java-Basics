public class Atoi {
	public static void main(String[] args) {
		String str = "   -12a13";
		System.out.println(myAtoi(str));
	}
	public static int myAtoi(String str) {
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			if (flag == 0 && str.charAt(i) == ' ')
				str = str.substring(0, i) + str.substring(1 + i--);
			else if (flag == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
				flag = 1;
				continue;
			}
			else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				str = str.substring(0, i);
				break;
			}
			else flag = 1;
		}
		int val = 0;
		try {
			val = Integer.valueOf(str);
		} catch (NumberFormatException e) {
			if (str.length() < 10) return 0;
			else if (str.charAt(0) == '-') return Integer.MIN_VALUE;
			else return Integer.MAX_VALUE;
		}
		return val;
	}
}