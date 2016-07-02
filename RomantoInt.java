import java.util.*;

public class RomantoInt {
	public static void main(String[] args) {
		String s = "CCVII";
		System.out.print(romanToInt(s) + "\n");
	}
	public static int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i != s.length()-1) {
				if (s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
					result--;
					continue;
				}
				if (s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
					result -= 10;
					continue;
				}
				if (s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
					result -= 100;
					continue;
				}	
			}
			result += map.get(s.charAt(i));
		}
		return result;
	}
}