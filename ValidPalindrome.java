import java.util.*;
public class ValidPalindrome {
	public static void main(String[] args) {
		String s = "race a car";
		System.out.println(isPalindrome(s));
	}
	public static boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char head = s.charAt(i);
			if (head > 47 && head < 58 || head > 96 && head < 123) {
				;
			} else if (head > 64 && head < 91) {
				head += 32;
			} else {
				i ++;
				continue;
			}

			char tail = s.charAt(j);
			if (tail > 47 && tail < 58 || tail > 96 && tail < 123) {
				;
			} else if (tail > 64 && tail < 91) {
				tail += 32;
			} else {
				j --;
				continue;
			}

			if (head == tail) {
				i ++;
				j --;
			} else {
				return false;
			}
		}
		return true;
	}
}