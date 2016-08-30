public class SuperUglyNumber {
	public static void main(String[] args) {
		int n = 12;
		int[] primes = {2, 7, 13, 19};
		for (int i = 1; i <= n; i ++) {
			System.out.print(nthSuperUglyNumber(i, primes) + " ");
		}
		System.out.print("\n");
	}
	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		int[] idx = new int[primes.length]; //current index in ugly.
		ugly[0] = 1;
		for (int i = 1; i < n; i ++) {
			ugly[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j ++) {
				ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
			}
			//push index of each prime number forward if equals to current ugly
			for (int j = 0; j < primes.length; j ++) {
				if (ugly[i] == primes[j] * ugly[idx[j]]) idx[j] ++;
			}
		}
		return ugly[n - 1];
	}
}