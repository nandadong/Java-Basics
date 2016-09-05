public class Wiggle {
	public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int length = 1, sign = 0;
        for (int i = 1; i < nums.length; i ++) {
            if ((nums[i] - nums[i - 1]) * sign < 0 || nums[i] != nums[i - 1] && sign == 0) {
                length ++;
                if (sign == 0) {
                    sign = (nums[i] - nums[i - 1]) / Math.abs(nums[i] - nums[i - 1]);
                }
                else sign = sign == 1 ? -1 : 1;
            }
        }
        return length;
    }
}
