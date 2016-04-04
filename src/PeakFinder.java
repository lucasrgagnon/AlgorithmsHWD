/**
 * Created by lucasgagnon on 4/1/16.
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
