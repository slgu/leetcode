package test;

import java.util.Stack;

/**
 * Created by slgu1 on 10/14/15.
 */
enum Suit {
    A(0), B(1), C(2), D(3);
    private int value;
    Suit(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public Suit getSuitFromValue(int value) {
        switch (value) {
            case 0: return A;
            case 1: return B;
            case 2: return C;
            case 3: return D;
            default: return A;
        }
    }
}

abstract class Card {
    abstract int getvalue();
}

public class Test4 {
    public static void main() {
    }
}
