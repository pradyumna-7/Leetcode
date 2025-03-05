class Solution {
    public long coloredCells(int n) {
        return (long)(2*Math.pow(n,2)) - (2*n) + 1; 
    }
}