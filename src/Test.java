/**
 * Created by slgu1 on 9/5/15.
 */
class B implements Cloneable{
    int c = 4;
    @Override
    public String toString() {
        return String.valueOf(c);
    }
    @Override
    protected Object clone(){
        try{
            return super.clone();
        }
        catch (CloneNotSupportedException e){
            System.out.println(e);
            return null;
        }
    }
}
class A implements Cloneable {
    int a = 3;
    String b = "haha";
    B c = new B();
    @Override
    public String toString() {
        return String.valueOf(a) + "," + b + c.toString();
    }

    @Override
    protected Object clone(){
        try{
            //deep copy
            A res = (A)super.clone();
            res.c = (B)c.clone();
            return res;
        }
        catch (CloneNotSupportedException e){
            return null;
        }
    }
}
public class Test {
    public static void main(String [] args){
        A a = new A();
        A b = (A)a.clone();
        b.a = 4;
        b.b = "ahah";
        a.c.c = 5;
        System.out.println(a);
        System.out.println(b);
    }
}
