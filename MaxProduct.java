import java.util.*;
public class MaxProduct {
	public static void main(String[] args) {
		String[] words = {"a", "aa", "aaa", "aaaa"};
		System.out.println(maxProduct(words));
	}
	public static int maxProduct(String[] words) {
		int[] mask = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				mask[i] |= 1 << (words[i].charAt(j) - 'a');
			}
		}
		int max = 0;
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((mask[i] & mask[j]) == 0 && words[i].length() * words[j].length() > max) {
					max = words[i].length() * words[j].length();
				}
			}
		}
		return max;
	}
}