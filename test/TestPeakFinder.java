import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lucasgagnon on 4/4/16.
 */
public class TestPeakFinder {

    @Test
    public void testOneValue() {
        int[] a = {1};
        PeakFinder pf = new PeakFinder(a);
        assertEquals(pf.findPeak(), 0);
    }

    @Test
    public void testTwoValue() {
        int[] a = {2, 1};
        PeakFinder pf = new PeakFinder(a);
        assertEquals(pf.findPeak(), 0);
        int[] b = {1, 2};
        pf.setArray(b);
        assertEquals(pf.findPeak(), 1);
    }

    @Test
    public void testThreeValue() {
        int[] a = {1, 2, 3};
        PeakFinder pf = new PeakFinder(a);
        assertEquals(pf.findPeak(), 2);
        int[] b = {1, 3, 2};
        pf.setArray(b);
        assertEquals(pf.findPeak(), 1);
        int[] c = {3, 2, 1};
        pf.setArray(c);
        assertEquals(pf.findPeak(), 0);
    }

    @Test
    public void testLargeArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        PeakFinder pf;
        pf = new PeakFinder(a);
        assertEquals(pf.findPeak(), 9);
        int[] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        pf.setArray(b);
        assertEquals(pf.findPeak(), 0);
        int[] c = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};
        pf.setArray(c);
        assertEquals(pf.findPeak(), 5);
    }

}