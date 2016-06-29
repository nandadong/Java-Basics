import java.util.*;
public class Intersection {
	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {};
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
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			hs.add(nums1[i]);
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (hs.contains(nums2[i])) {
				al.add(nums2[i]);
				hs.remove(nums2[i]);
			}
		}

		int[] result = new int[al.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = al.get(i);
		}
		return result;
	}
}