import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lucasgagnon on 4/4/16.
 */
public class TestMaxContigSeq {

    @Test
    public void testMaxInL() {
        int[] a = {10, 5, -1, 1};
        MaxContigSeq mcs = new MaxContigSeq(a);
        assertEquals(15, mcs.findMaxContigSeq());
    }

    @Test
    public void testMaxInR() {
        int[] a = {10, -10, -1, 100};
        MaxContigSeq mcs = new MaxContigSeq(a);
        assertEquals(100, mcs.findMaxContigSeq());
    }

    @Test
    public void testMaxInSpan() {
        int[] a = {10, 5, -1, 100};
        MaxContigSeq mcs = new MaxContigSeq(a);
        assertEquals(114, mcs.findMaxContigSeq());
    }

    @Test
    public void testAllNegs() {
        int[] a = {-10, -5, -1, -100};
        MaxContigSeq mcs = new MaxContigSeq(a);
        assertEquals(-1, mcs.findMaxContigSeq());
    }

    @Test
    public void testZero() {
        int[] a = {0, 0, 0, 0, -1};
        MaxContigSeq mcs = new MaxContigSeq(a);
        assertEquals(0, mcs.findMaxContigSeq());
    }

    @Test
    public void testExampleThatBrokeArisAlgorithm() {
        int[] a = {2, 2, -10, 1, 2, 2, 1, -10, 2, 2};
        MaxContigSeq mcs = new MaxContigSeq(a);
        assertEquals(6, mcs.findMaxContigSeq());
    }
}