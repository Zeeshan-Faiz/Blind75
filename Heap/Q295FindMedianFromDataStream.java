package Heap;

/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is 
no middle value, and the median is the mean of the two middle values.

    For example, for arr = [2,3,4], the median is 3.
    For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

Implement the MedianFinder class:

    MedianFinder() initializes the MedianFinder object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual 
    answer will be accepted.

Example 1:
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
*/

public class Q295FindMedianFromDataStream {
    
    int[] hashVals;
    int median;
    int medianCount2x;

    public Q295FindMedianFromDataStream() {
        hashVals = new int[200001];
        median = Integer.MIN_VALUE;
        medianCount2x = 1;
    }
    
    public void addNum(int num) {
        hashVals[num+100000]++;
        if (median != Integer.MIN_VALUE) {
            if (num > median) {
                if (medianCount2x < 2*hashVals[median+100000]) {
                    medianCount2x++;
                } else {
                    medianCount2x = 1;
                    while (hashVals[++median+100000] == 0) {}
                }
            } else if (num < median) {
                if (medianCount2x > 1) {
                    medianCount2x--;
                } else {
                    while (hashVals[--median + 100000] ==0) {}
                    medianCount2x = 2*hashVals[median+100000];
                }
            } else {
                medianCount2x++;
            }
        } else {
            median = num;
        }
    }
    
    public double findMedian() {
        if (medianCount2x % 2 == 0) {
            if (2*hashVals[median+100000] > medianCount2x) {
                return median;
            } else {
                int median2 = median;
                while (hashVals[++median2 + 100000] == 0) {}
                return (median + median2)/2.0;
            }
        } else {
            return median;
        }
    }
}