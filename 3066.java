//Approach is below
class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if(n<2) return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++) pq.add((long)(nums[i]));
        if(pq.peek() > k) return 0;
        int count =0;
        while(pq.peek()<k){
            if(pq.size()<2){
                break;
            }
            Long x = pq.poll();
            Long y = pq.poll();
            Long val = Math.min(x,y) * 2 + Math.max(x,y);
            pq.add(val);
            count++;
        }
        return count;
    }
}
/*
The approach follows a Greedy + Min-Heap (Priority Queue) strategy, similar to the "Min Heap Mixing" problem.

Approach:
Use a Min-Heap (PriorityQueue) to always access the smallest elements efficiently.

Edge Cases:
    If the array has less than two elements, return 0 immediately.
    If the smallest element is already >= k, return 0 as no operations are needed.

Main Logic:
1.Keep extracting the two smallest numbers from the heap.

2.Combine them using the formula:
    new value=min(x,y)×2+max(x,y)

3. Push the new value back into the heap.
    Repeat from step 1 until the smallest element in the heap is >= k.

4. Return the operation count.
 */