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
