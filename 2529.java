//Approach below Solution
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length -1;
        int neg = findNegative(nums, 0, n);
        int pos = findPositive(nums, 0, n);
        return Math.max(neg, n-pos+1);
    }

    public int findPositive(int []nums, int left, int right){
        while(left<=right){
            int mid = left + (right-left) /2;
            if(nums[mid]>0) right = mid-1;
            else left = mid +1;
        }
        return left;
    }

    public int findNegative(int []nums, int left, int right){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<0) left = mid+1;
            else right = mid-1;
        }
        return left;
    }


}

/*
The problem requires finding whether there are more negative or positive numbers in a sorted array and 
returning the maximum count among them. Given that the array is sorted in non-decreasing order, 
we can leverage binary search to efficiently determine the count of negative and positive numbers.

Steps
1. Find the first occurrence of a positive number
    -We use a binary search function findPositive(nums, left, right).
    -This function finds the leftmost index where a positive number appears.
    -The number of positive elements is determined as n - pos + 1, where pos is the index of the first positive number.

2. Find the count of negative numbers
    -We use a binary search function findNegative(nums, left, right).
    -This function finds the leftmost index where a non-negative number appears.
    -Since the negatives are before this index, the number of negative elements is directly given by this index.

3. Return the maximum of both counts
    -We take the maximum of the two counts to get the final result
 */