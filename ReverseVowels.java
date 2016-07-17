import java.util.*;
public class ReverseVowels {
	public static void main(String[] args) {
		String s = "race car";
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
		char[] ch = s.toCharArray();
		int start = 0;
		int end = ch.length - 1;
		while (start < end) {
			if (vowels.contains(ch[start]) && vowels.contains(ch[end])) {
				char temp = ch[start];
				ch[start] = ch[end];
				ch[end] = temp;
				start ++;
				end --;
			} else {
				if (!vowels.contains(ch[start])) {
					start ++;
				}
				if (!vowels.contains(ch[end])) {
					end --;
				}
			}
		}
		return new String(ch);
	}
}