class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, 0);
        return res;
    }
    public void backTrack(int[]nums, int start, int target, int sum){
        if(target == sum){
            res.add(new ArrayList<> (path));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if((start < i && nums[i] == nums[i-1]) ||sum > target || sum+nums[i] > target){
                continue;
            }
            path.add(nums[i]);
            sum += nums[i];
            backTrack(nums, i+1, target, sum);
            sum -= path.get(path.size()-1);
            path.remove(path.size()-1);
        }
    }
}
