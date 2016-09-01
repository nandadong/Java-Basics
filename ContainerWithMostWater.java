public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        int low = 0, high = height.length - 1, max = Integer.MIN_VALUE;
        while (low < high) {
            max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
            if (height[low] < height[high]) low ++;
            else high --;
        }
        return max;
    }	
}