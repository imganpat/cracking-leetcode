// Approach: Two Heaps (Max Heap + Min Heap)
// 1. Maintain two heaps:
//    - maxHeap → stores the smaller half of numbers (largest at the top).
//    - minHeap → stores the larger half of numbers (smallest at the top).
// 2. When inserting a new number:
//    - First push it into maxHeap.
//    - Move the largest element of maxHeap to minHeap to maintain order.
// 3. Balance the heaps:
//    - Ensure maxHeap always has equal or one more element than minHeap.
//    - If minHeap becomes larger, move its top element back to maxHeap.
// 4. Finding the median:
//    - If heaps are equal size → median = average of two heap tops.
//    - If maxHeap has one extra element → median = maxHeap.peek().
//
// Time complexity:
//   addNum() → O(log n) due to heap insertion/removal
//   findMedian() → O(1)
//
// Space complexity: O(n) – heaps store all inserted numbers

class MedianFinder {

    PriorityQueue<Integer> minHeap; // stores larger half
    PriorityQueue<Integer> maxHeap; // stores smaller half

    public MedianFinder() {
        // Min heap for larger numbers
        minHeap = new PriorityQueue<>();

        // Max heap for smaller numbers
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {

        // Step 1: Add number to maxHeap
        maxHeap.add(num);

        // Step 2: Move the largest element to minHeap
        minHeap.add(maxHeap.poll());

        // Step 3: Balance the heaps
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {

        // If heaps are not equal, maxHeap has the extra element
        if (minHeap.size() != maxHeap.size()) {
            return maxHeap.peek();
        }

        // If equal size, median is average of two middle values
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

/*
Usage:
MedianFinder obj = new MedianFinder();
obj.addNum(num);
double median = obj.findMedian();
*/