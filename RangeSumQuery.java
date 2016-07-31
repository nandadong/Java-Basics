public class RangeSumQuery {
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray numarr = new NumArray(nums);
		System.out.print(numarr.sumRange(0, 2) + "\n");
	}
}
class NumArray {
	int[] nums;
	public NumArray(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i-1];
		}
		this.nums = nums;
	}
	public int sumRange(int i, int j) {
		if (i == 0) {
			return nums[j];
		}
		return nums[j] - nums[i-1];
	}
}