import java.util.*;

public class IntersectionII {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] result = intersect(nums1, nums2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.print("\n");
	}
	public static int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			l1.add(nums1[i]);
		}
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for (int j = 0; j < nums2.length; j++) {
			if(l1.contains(nums2[j])) {
				l2.add(nums2[j]);
				l1.remove(l1.indexOf(nums2[j]));
			}
		}
		int[] result = new int[l2.size()];
		for (int k = 0; k < result.length; k++) {
			result[k] = l2.get(k);
		}
		return result;
	}
}