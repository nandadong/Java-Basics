public class AddDigits {
	public static void main(String[] args) {
		int num = 386;
		System.out.println(addDigits(num) + "\n");
		
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
