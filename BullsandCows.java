import java.util.*;
public class BullsandCows {
	public static void main(String[] args) {
		System.out.print(getHint("1807","7810") + "\n");
	}
	public static String getHint(String secret, String guess) {
		int A = 0, B = 0, len = secret.length();
		int[] count = new int[10];
		for (int i = 0; i < len; i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				A ++;
			} else {
				count[secret.charAt(i) - '0'] ++;
				if (count[secret.charAt(i) - '0'] <= 0) {
					B ++;
				}
				count[guess.charAt(i) - '0'] --;
				if (count[guess.charAt(i) - '0'] >= 0) {
					B ++;
				}
			}
		}
		return A + "A" + B + "B";
	}
}