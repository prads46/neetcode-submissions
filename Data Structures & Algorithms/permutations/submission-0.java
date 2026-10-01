class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums);
        return res;
    }
    public void backTrack(int[]nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            backTrack(nums);
            path.remove(path.size()-1);
        }
    }
}
