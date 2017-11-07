package uk.co.wnij9.section6;

public interface JDK9Interface {

    void method1();
    String method2(String s);

    default void method3 () { setup(); }

    default void method4 () { setup(); }

    private void setup() {
        System.out.println("Default behaviour setup");
    }

    default void method5 (String s) {
        staticSetup(s);
    }

    private static void staticSetup(String s) {
    }
}
