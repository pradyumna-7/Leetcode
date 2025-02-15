//Approach explained below
class Solution {
    static ArrayList<Integer> result = new ArrayList<>();
    public int punishmentNumber(int n) {
        int output = 0;
       for(int i=1; i<=n; i++){
            if(partition(String.valueOf(i*i),i,0,0))output=output+(i*i);
       }
       return output;
    }

    public static boolean partition(String num, int target, int parti, int idx){
        if(idx==num.length()){
            if(parti==target) return true;
            else return false;
        }
        for(int i=idx; i<num.length(); i++){
            int curr = Integer.parseInt(num.substring(idx, i+1));
            if(partition(num, target, parti + curr, i+1))return true;
        }
        return false;
    }
}
/*
Step-by-Step Approach
Initialize a variable output to store the sum of punishment numbers.

Iterate through all numbers i from 1 to n:

Compute i * i (square of i).
Convert i * i to a string for easier partitioning.
Call the recursive partition() function to check if it can be split into contiguous substrings whose sum equals i.
If partition() returns true, add i * i to output.
Define a recursive function (in this case it is backtracking) partition(num, target, parti, idx):

Base Case:
If idx (current position in the string) reaches num.length(), check if parti (the sum of selected partitions) is equal to target.
If yes, return true, otherwise return false.
Recursive Case:
Iterate from the current index idx to num.length(), extracting possible contiguous substrings.
Convert each substring to an integer curr.
Recursively call partition() with updated parti = parti + curr and the new index i + 1.
If any recursive call returns true, return true.
If no valid partitioning is found, return false.
Return output as the final punishment number of n.


 */