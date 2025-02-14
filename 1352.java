class ProductOfNumbers {
    List<Integer> stream;
    int last;
    public ProductOfNumbers() {
        this.stream = new ArrayList<>();
        this.last=-1;
    }
    
    public void add(int num) {
        stream.add(num);
        last+=1;
    }
    
    public int getProduct(int k) {
        int prod=1;
        for(int i=last, j=0; j<k; i--, j++){
            prod = prod * stream.get(i);
        }
        return prod;    
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */