package Java_SE8_ForRI.ch1.ex11.case4;


public abstract class MyClass implements I, J{

    //We are forced to provide an implementation for this method because it is declared in both interfaces
    //It doesn't matter that one of them provides an implementation for the method
    public void f() {
        J.super.f();
    }
}
