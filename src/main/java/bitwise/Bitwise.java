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
}
