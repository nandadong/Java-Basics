public class AddDigits {
	public static void main(String[] args) {
		int num = 11;
		//formula of digital sum, O(1)
		int dr = num - 9*((num-1)/9);
		System.out.println(addDigits(num));
		System.out.println(dr + "\n");
		
	}
	public static int addDigits(int num) {
		//num >= 0
		if(num/10 == 0) {
			return num;
		}
		int temp = 0;
		while(num/10 != 0) {
			temp += num%10;
			num = num/10;
		} 
		temp += num%10;
		return addDigits(temp);
	}
}
