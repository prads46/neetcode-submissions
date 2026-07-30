class MedianFinder {
    private List<Integer> list;
    public MedianFinder() {
        this.list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list); 
        boolean isEven = list.size()%2 == 0;
        int mid = list.size()/2;
        double ans = 0.0;
        if(isEven){
            ans = (list.get(mid-1)+ list.get(mid))/2.0;
            return ans;
        }
        ans = list.get(mid);
        return ans;
    }
}
