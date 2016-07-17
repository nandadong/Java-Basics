import java.util.*;
public class ReverseVowels {
	public static void main(String[] args) {
		String s = "leetcode";
		System.out.print(reveseVowels(s) + "\n");
	}
	public static String reveseVowels(String s) {
		HashSet<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		char[] charry = s.toCharArray();
		int j = charry.length - 1;
		for (int i = 0; i < charry.length; i++) {
			if (vowels.contains(charry[i])) {
				for (; j > i; j--) {
					if (vowels.contains(charry[j])) {
						char temp = charry[i];
						charry[i] = charry[j];
						charry[j] = temp;
						j--;
						break;
					}
				}
			}
		}
		String result = new String(charry);
		return result;
	}
}