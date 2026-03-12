class MedianFinder {
    PriorityQueue<Integer> minHeap; 
    PriorityQueue<Integer> maxHeap; 

    public MedianFinder() {    
        minHeap= new PriorityQueue<>();
        maxHeap= new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.add(num);

        minHeap.add(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() != maxHeap.size()){
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */