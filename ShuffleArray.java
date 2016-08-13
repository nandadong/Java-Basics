import java.util.*;
public class ShuffleArray {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		Solution solution = new Solution(nums);
		for (int num : solution.shuffle()) System.out.print(num + " ");
		System.out.print("\n");

		for (int num : solution.reset()) System.out.print(num + " ");
		System.out.print("\n");
	}
}
class Solution {
	int[] nums;
	Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int[] array = nums.clone();
    	for (int i = 1; i < array.length; i++) {
    		int rand = random.nextInt(i + 1);
    		/*** Swap visited element randomly. ***/
    		int temp = array[i];
    		array[i] = array[rand];
    		array[rand] = temp;
    	}
    	return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */