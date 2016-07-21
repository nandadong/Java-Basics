public class GuessGame {
	public static void main(String[] args) {
		int n = 2126753390;
		System.out.print(guessNumber(n) + "\n");
	}
	public static int guessNumber(int n) {
		if (n == 1) {
            return 1;
        }
        long low = 1;
        long high = n;
        int g = guess((int)((low + high)/2));
        while (g != 0) {
            if (g == -1) {
                high = (low + high)/2 - 1;
            } else {
                low = (low + high)/2 + 1;
            }
            g = guess((int)((low + high)/2));
        }
        int myguess = (int)((low + high)/2);
        return myguess;
	}
	public static int guess(int myguess) {
		int realnum = 1702766719;
		if (myguess > realnum) {
			return -1;
		} else if (myguess < realnum) {
			return 1;
		} 
		return 0;
	}
}