package Java_SE8_ForRI.ch1.ex11.case2;


public class MyClass implements I, J {

    public static void main(String[] args) {

        //Default f() method in both interfaces => conflict
        //We have to override the method in this class to resolve this

        MyClass myClass = new MyClass();
        myClass.f();

    }

    public void f() {
        I.super.f();
    }
}
