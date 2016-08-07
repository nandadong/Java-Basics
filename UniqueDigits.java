public class UniqueDigits {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(countNumberWithUniqueDigits(n));
	}
	public static int countNumberWithUniqueDigits(int n) {
		int sum = 1, i = 0, current = 9, follow = 9;
		while (i < n && follow > 0) {
			if (i == 0) {
				sum += current;
				i ++;
				continue;
			}
			sum += current * follow;
			current *= follow;
			follow --;
			i ++;
		}
		return sum;
	}
}