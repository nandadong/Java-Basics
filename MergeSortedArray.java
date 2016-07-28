import java.util.Arrays;
public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, -1, -1, -1, -1, -3}, nums2 = {1, 4, 5};
		int m = 3, n = 3;
		merge(nums1, m, nums2, n);
		for (int element : nums1) {
			System.out.print(element + " ");
		}
		System.out.print("\n");
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, index = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i--];
			} else {
				nums1[index--] = nums2[j--];
			}
		}
		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}
	}
}