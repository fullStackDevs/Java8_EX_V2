package Java_SE8_ForRI.ch1.ex11.case6;

public class MyClass implements I, J {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.testMethodFromInterf();

    }

    public void testMethodFromInterf() {
        // #*# inherited default method from interface J
        f();

        // #*# static method from interface I
        I.f();
    }
}
