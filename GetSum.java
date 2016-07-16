public class GetSum {
	public static void main(String[] args) {
		int a = 1;
		int b = 14;
		System.out.print(getSum(a,b) + "\n");
		
	}
	public static int getSum(int a, int b) {
		
		while (b != 0) {
			int c = a & b;	//carry bit
			a = a ^ b;	//sum without carry
			b = c << 1;	
		}
		return a;
	}
}