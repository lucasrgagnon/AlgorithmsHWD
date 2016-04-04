/**
 * Created by lucasgagnon on 4/4/16.
 * This code assumes the assumptions given in the assignment.
 * These are:
 *  -Each entry of the array contains a distinct number,
 *  -For some index p between 0 and n-1, the values in the
 *   array increase up to position p in A and then decrease
 *   the remainder of the way until position n-1,
 *
 * Additionally, we assume:
 *  -The peak of an array with one or two values is the max,
 *  -Peaks can exist as the first or last entry of the array,
 *  -Empty arrays will not be passed.
 *
 * The findPeak method runs in constant time, and has the
 * following recusion: f(n) = f(n/2) + c, f(1) = 1, f(2) = 1. Thus,
 * by the master theorem this algorithm should be in O(log(n)).
 */
public class PeakFinder {

    // Input Array.  Assuming values are integer because who really cares.
    int[] array;

    public PeakFinder(int[] array) {
        this.array=array;
    }

    public int findPeak() throws IllegalArgumentException {
        if (array.length == 0) {
            System.out.println("Array is empty");
            throw new IllegalArgumentException();
        }
        return findPeak(0, array.length - 1);
    }

    private int findPeak(int minIndex, int maxIndex) {
        if (maxIndex - minIndex < 3) {
            return shortArrayReturn(minIndex, maxIndex);
        }
        int midIndex = (maxIndex + minIndex) / 2 + 1;
        if (array[midIndex] > array[midIndex - 1]) {
            if (array[midIndex] > array[midIndex + 1]) {
                return midIndex;
            } else {
                return findPeak(midIndex, maxIndex);
            }
        } else {
            return findPeak(minIndex, midIndex);
        }
    }

    private int shortArrayReturn(int minIndex, int maxIndex) {
        if (maxIndex == minIndex) {
            return minIndex;
        }else if (maxIndex == minIndex + 1) {
            if (array[minIndex] > array[maxIndex]) {
                return minIndex;
            } else {
                return maxIndex;
            }
        } else {
            if (array[minIndex] > array[minIndex + 1]) {
                return minIndex;
            } else if (array[minIndex + 1] > array[maxIndex]){
                return minIndex + 1;
            } else {
                return maxIndex;
            }
        }

    }

    public void setArray(int[] array) {
        this.array = array;
    }

}
