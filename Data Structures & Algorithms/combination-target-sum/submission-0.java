class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backTrack(nums, 0, target, 0);
        return res;

    }
    public void backTrack(int[]nums, int start, int target, int sum){
        if(sum == target){
            res.add(new ArrayList<> (path));
            return;
        }
        for(int i=start; i< nums.length;i++){
            if(sum > target || sum+nums[i] > target) break;
            path.add(nums[i]);
            sum += nums[i];
            backTrack(nums, i, target, sum);
            sum -= path.get(path.size()-1);
            path.remove(path.size()-1);
        }
    }
}
