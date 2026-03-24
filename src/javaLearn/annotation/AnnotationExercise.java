package javaLearn.annotation;

public @interface AnnotationExercise {
    String aaa();
    boolean bbb() default true;
    String[] ccc();
}
