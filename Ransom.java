import java.util.*;
public class Ransom {
	public static void main(String[] args) {
		System.out.println(canConstruct("", ""));
	}
	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == "") return true;
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < ransomNote.length(); i++) {
			list.add(ransomNote.charAt(i));
		}
		for (int i = 0; i < magazine.length(); i++) {
			if (list.contains(magazine.charAt(i))) list.remove(list.indexOf(magazine.charAt(i)));
			if (list.size() == 0) return true;
		}
		return false;
	}
}