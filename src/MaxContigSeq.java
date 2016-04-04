/**
 * Created by lucasgagnon on 4/4/16.
 */
public class MaxContigSeq {

    // Input Array.  Assuming values are integer because who really cares.
    int[] array;

    public MaxContigSeq(int[] array) {
        this.array=array;
    }

    public int findMaxContigSeq() throws IllegalArgumentException{
        if (array.length == 0) {
            System.out.println("Array is empty");
            throw new IllegalArgumentException();
        }
        return findMaxContigSeq(0, array.length - 1);
    }

    private int findMaxContigSeq(int minIndex, int maxIndex) {
        if (minIndex == maxIndex) {
            return array[minIndex];
        } else{
            int midIndex = (maxIndex + minIndex) / 2 + 1;

            int maxLeft = findMaxContigSeq(minIndex, midIndex - 1);
            int maxRight = findMaxContigSeq(midIndex, maxIndex);
            int maxSpan = findMaxSpan(midIndex - 1, minIndex, -1) + findMaxSpan(midIndex, maxIndex, 1);

            if (maxLeft >= maxRight) {
                if (maxLeft >= maxSpan) {
                    return maxLeft;
                } else {
                    return maxSpan;
                }
            } else if (maxSpan >= maxRight) {
                return maxSpan;
            } else {
                return maxRight;
            }
        }
    }

    private int findMaxSpan(int startIndex, int boundIndex, int step) {
        if (startIndex == boundIndex) {
            return array[startIndex];
        }
        int max = array[startIndex];
        int accumulator = array[startIndex];
        for (int i = startIndex + step; (step/Math.abs(step))*i <= (step/Math.abs(step))*boundIndex; i += step) {
            accumulator += array[i];
            if (accumulator > max) {
                max = accumulator;
            }
        }
        return max;
    }

    public void setArray(int[] array) {this.array = array;}
}
