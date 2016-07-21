import java.util.*;
public class BullsandCows {
	public static void main(String[] args) {
		System.out.print(getHint("1123","0111") + "\n");
	}
	public static String getHint(String secret, String guess) {
		int A = 0, B = 0, len = secret.length();
		for (int i = 0; i < len; i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				secret = secret.substring(0,i) + secret.substring(i+1);
				guess = guess.substring(0,i) + guess.substring(i+1);
				i --;
				len --;
				A ++;
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (secret.charAt(i) == guess.charAt(j)) {
					secret = secret.substring(0,i) + secret.substring(i+1);
					guess = guess.substring(0,j) + guess.substring(j+1);
					i --;
					len --;
					B ++;
					break;
				}
			}
		}
		return A + "A" + B + "B";
	}
}