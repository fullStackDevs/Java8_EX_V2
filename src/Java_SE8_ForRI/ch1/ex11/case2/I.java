package Java_SE8_ForRI.ch1.ex11.case2;


public interface I {

    default void f(){
        System.out.println("Default implementation for the method 'void f()' from the interface I");
    }
}
