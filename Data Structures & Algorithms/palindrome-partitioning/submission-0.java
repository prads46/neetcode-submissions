class Solution {
    public List<List<String>> res = new ArrayList<>();
    public List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s,0);
        return res;
    }
    public void backTrack(String s, int start){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end = start+1; end <= s.length(); end++){
            String piece = s.substring(start,end);
            if(isPalindrome(piece)){
                path.add(piece);
                backTrack(s,end);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
