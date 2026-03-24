package leetCode.Test;

public class A {
    static {
        System.out.println("static A");
    }

    {
        System.out.println("inner A");
    }

    public A() {
        System.out.println("construct A");
    }

    public A(int a) {
        System.out.println("construct A: " + a);
    }
}
