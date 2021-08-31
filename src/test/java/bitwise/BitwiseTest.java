package bitwise;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitwiseTest {

    @Before
    public void init() {
    }

    @Test
    public void testBitwise() {
        assertEquals(Bitwise.bitwiseOr(2,2), 2);
        assertEquals(Bitwise.bitwiseAnd(2,2), 2);
        assertEquals(Bitwise.bitwiseXOR(2,2), 0);
        assertEquals(Bitwise.bitwiseComplement(2), -3);
        assertEquals(Bitwise.leftShit(2), 4);
        assertEquals(Bitwise.rightShift(2), 1);
        assertEquals(Bitwise.rightShift(-2), -1);
        assertEquals(Bitwise.unsignedRightShift(2), 1);
    }

}
