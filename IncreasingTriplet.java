public class IncreasingTriplet {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		System.out.println(increasingTriplet(nums));
	}
	public static boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= small) small = num;
			else if (num <= big) big = num;
			else return true;
		}
		return false;
	}
}