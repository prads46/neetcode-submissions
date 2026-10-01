class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return res;
    }
    public void backTrack(int[]nums, int start){
        res.add(new ArrayList<> (path));
        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            backTrack(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
