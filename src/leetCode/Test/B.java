package leetCode.Test;

public class B extends A{
    static {
        System.out.println("static B");
    }

    {
        System.out.println("inner B");
    }

    private String instanceFieldB = initInstanceFieldB();

    private String initInstanceFieldB() {
        System.out.println("B的实例字段初始化");
        return "instanceB";
    }

    public B() {
        System.out.println("construct B");
    }

    public B(int a) {
        super();
        System.out.println("construct B: " + a);
    }
}
