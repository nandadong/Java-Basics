public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        subsetsHelper(list, new ArrayList<Integer>(), 0, nums);
        return list;
    }
    private void subsetsHelper (List<List<Integer>> list, List<Integer> current, int index, int[] nums) {
        list.add(new ArrayList<Integer>(current));
        for (int i = index; i < nums.length; i ++) {
            current.add(nums[i]);
            subsetsHelper(list, current, i + 1, nums);
            current.remove(current.size()-1);
        }
    }
}
