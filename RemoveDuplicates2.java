public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int count = 0, p = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1]) {
                count ++;
            } else {
                count = 0;
            }
            if (count < 2) {
                nums[p] = nums[i];
                p ++;
            }
        }
        return p;
    }
}
