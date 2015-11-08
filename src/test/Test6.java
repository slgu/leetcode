package test;

/**
 * Created by slgu1 on 10/19/15.
 */
class Tmp <T> {
    Tmp(T b) {
        c = b;
    }
    T fuck() {
        return c;
    }
    private T c;

}



public class Test6 {
    public static <T extends Tmp<Integer>> void fuck() {

    }
}
