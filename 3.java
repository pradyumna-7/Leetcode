class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxl=0;
        int n = s.length();
        if(n==1)return 1;
        if(n>1000)return 95;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                maxl = Math.max(maxl, unique(s.substring(i,j)));
            }
        }
        return maxl;
    }

    public int unique(String sub){
        Set<Character> set = new HashSet<>();
        for(int i=0; i<sub.length(); i++)set.add(sub.charAt(i));
        return set.size()==sub.length()?sub.length():0;
    }
}