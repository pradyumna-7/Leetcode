//Approach explained below code
class Solution {
    public int maximumSum(int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());

        for (int num : nums) {
            int digitSum = sumDigits(num);
            map.putIfAbsent(digitSum, new ArrayList<>());
            map.get(digitSum).add(num);
        }

        int maxSum = -1;
        for (List<Integer> values : map.values()) {
            if (values.size() > 1) {
                values.sort(Collections.reverseOrder());
                maxSum = Math.max(maxSum, values.get(0) + values.get(1));
            }
        }

        return maxSum;
    }

    static int sumDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

/*
The approach groups numbers based on their digit sum and finds the two largest numbers in each group to compute the maximum possible sum.


1. Group numbers by digit sum
    Use a TreeMap<Integer, List<Integer>>, where the key is sumDigits(num), and the value is a list of numbers having that digit sum.
    The TreeMap maintains keys in descending order.

2.Sort each group to get the top two numbers
    For each digit sum, sort the list in descending order.
    If the list has at least two numbers, take the two largest and compute their sum.

Return the maximum valid sum
If no valid pair exists, return -1.

*/