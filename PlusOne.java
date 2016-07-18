import java.util.*;
public class PlusOne {
	public static void main(String[] args) {
		int[] digits = {9, 9, 9, 9, 9, 9, 9, 9};
		int[] plus = plusOne(digits);
		for (int digit : plus) {
			System.out.print(digit);
		}
		System.out.print("\n");
	}
	public static int[] plusOne(int[] digits) {
		if (digits == null) {
			return null;
		}
		if (digits[digits.length - 1] != 9) {
			digits[digits.length - 1] += 1;
			return digits;
		}
		int carry = 1;
		int index = digits.length - 1;
		while (carry == 1) {
			if (carry + digits[index] == 10) {
				if (index == 0) {
					digits = new int[digits.length + 1];
					for (int i = 0; i < digits.length; i++) {
						digits[i] = 0;
					}
					digits[0] = 1;
					return digits;
				}
				digits[index] = 0;
				index --;
			} else {
				digits[index] += 1;
				carry = 0;
			}
		}
		return digits;
	}
}