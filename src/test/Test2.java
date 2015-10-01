package test;

/**
 * Created by slgu1 on 9/19/15.
 */
class OneValueCache {
    private final String key;
    private final String value;
    OneValueCache(String key, String value) {
        System.out.println(key);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){

        }
        this.key = key;
        this.value = value;
        System.out.println(value);
    }
}

public class Test2 {
    public void test() {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                cache = new OneValueCache("fuck", "yes");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                cache = new OneValueCache("fuck", "yes");
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            //
        }
    }
    public static void main(String [] args) {
        Test2 a = new Test2();
        a.test();
    }
    protected volatile OneValueCache cache = null;
}
