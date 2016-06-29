import java.util.*;
public class Intersection {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] intersect = intersection(nums1, nums2);
		for (int i = 0; i < intersect.length; i++) {
			System.out.print(intersect[i] + " ");
		}
		System.out.print("\n");
	}
	public static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = i + 1; j < nums1.length; j++) {
				if (nums1[i] == nums1[j]) {
					nums1[j] = Integer.MAX_VALUE;
				}
			}
			// System.out.print(nums1[i] + " ");
		}
		// System.out.print("\n");
		for (int i = 0; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j]) {
					list.add(nums1[i]);
					break;
				}
			}
		}
		int[] result = new int[list.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}