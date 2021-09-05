package bitwise;

public class Bitwise {

    public static int bitwiseOr(int a, int b) {
        return a | b;
    }

    public static int bitwiseAnd(int a, int b) {
        return a & b;
    }

    public static int bitwiseXOR(int a, int b) {
        return a ^ b;
    }

    public static int bitwiseComplement(int a) {
        return ~a;
    }

    public static int leftShit(int a) {
        return a << 1;
    }

    public static int rightShift(int a) {
        return a >> 1;
    }

    public static int unsignedRightShift(int a) {
        return a >>> 1;
    }

    public static short countBitsSetToOne(int a) {
        short count = 0;

        while (a != 0) {
            count += (a & 1);

            a >>>= 1;
        }

        return count;
    }

    public static int returnParity(int a) {
        short count = 0;

        while (a != 0) {
            count += (a & 1);
            a >>>= 1;
        }

        if (count % 2 == 0)
            return 0;
        else
            return 1;
    }

    public static long bitSwap(long number, int i, int j) {

        if (((number >>> i) & 1) != ((number >>> j) & 1)){
            long bitMask = (1L << i) | (1L << j);

            number ^= bitMask;
        }

        return number;
    }
}
