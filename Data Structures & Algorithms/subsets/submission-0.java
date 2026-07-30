class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return result;
    }
    public void backTrack(int[]nums, int index){
        result.add(new ArrayList<>(current));
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            backTrack(nums, i+1);
            current.remove(current.size()-1);
        }
    }
}
