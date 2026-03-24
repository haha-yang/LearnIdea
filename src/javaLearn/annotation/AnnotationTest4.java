package javaLearn.annotation;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;

public class AnnotationTest4 {

    @AnnotationExercise4
    public void test1() {
        System.out.println("------ test1 -----");
    }

    @AnnotationExercise4
    public void test2() {
        System.out.println("------ test2 -----");
    }

//    @AnnotationExercise4
    public void test3() {
        System.out.println("------ test3 -----");
    }

    @AnnotationExercise4
    public void test4() {
        System.out.println("------ test4 -----");
    }

    public static void main(String[] args) throws Exception {
        // 启动程序:
        // 1.得到class对象
        Class c = AnnotationTest4.class;
        // 2.提取这个类中的所有成员方法
        Method[] methods = c.getDeclaredMethods();
        AnnotationTest4 test4 = (AnnotationTest4) c.getDeclaredConstructor().newInstance();
        // 3.遍历这个数组中的每个方法，看方法上是否存在@AnnotationExercise4注解，存在，触发该方法执行
        for (Method method : methods) {
            if (method.isAnnotationPresent(AnnotationExercise4.class)) {
                method.invoke(test4);
            }
        }
    }
}
