package Java_SE8_For_RI.ch1.ex11.case1;


public class MyClass implements I, J{

    public static void main(String[] args) {

//        11. Suppose you have a class that implements two interfaces I and J, each of
//        which has a method void f(). Exactly what happens if f is an abstract, default,
//        or static method of I and an abstract, default, or static method of J? Repeat
//        where a class extends a superclass S and implements an interface I, each
//        of which has a method void f().

        // a)
        MyClass myClass = new MyClass();
        myClass.f();


    }


    // a) When the method is abstract in both interfaces the class that implements the interfaces
    // must provide an implementation for the method - there is no conflict
    // It works as before Java 8
    public void f(){
        System.out.println("The implemenation of the abstract method 'void f()' was called");
    }
}
