package javaLearn.annotation;

@AnnotationExercise(aaa = "class", ccc = {"Class", "Interface"})
@AnnotationExercise2("haha")
@AnnotationExercise3()
public class AnnotationTest {
    @AnnotationExercise(aaa = "method", bbb = false, ccc = {"nihao", "hehe"})
    @AnnotationExercise3()
    public void test1() {

    }

    private String name;
}
