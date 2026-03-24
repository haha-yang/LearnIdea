package javaLearn.single;

public class SingleInstance {
    public static volatile String a = "123";
    public static SingleInstance getInstance() {
        return SubInstance.instance;
    }

    private static class SubInstance {
        private final static SingleInstance instance = new SingleInstance();
    }

    private SingleInstance() {

    }
}
