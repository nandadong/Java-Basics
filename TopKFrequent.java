import java.util.*;
public class TopKFrequent {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3, 3};
		int k = 2;
		System.out.println(topKFrequent(nums, k));
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) 
			map.put(num, map.getOrDefault(num, 0) + 1);
		List<Integer>[] bucket = new List[nums.length+1];	//mark, instatiation of List[], but got unchecked warning
		for (int key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null)	bucket[frequency] = new ArrayList<Integer>();
			bucket[frequency].add(key);
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = bucket.length-1; i >= 0 && result.size() < k; i--) {
			if (bucket[i] != null)	result.addAll(bucket[i]);
		}
		return result;
	}
}