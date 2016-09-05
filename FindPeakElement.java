public class FindPeakElement {
	public int findPeakElement(int[] nums) {
        return findHelper(nums, 0, nums.length - 1);
    }
    private int findHelper(int[] nums, int start, int end) {
        if (start == end) return start;
        if (start + 1 == end) return nums[start] > nums[end] ? start : end;
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
        else if(nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) return findHelper(nums, start, mid - 1);
        else return findHelper(nums, mid + 1, end);
    }
}
