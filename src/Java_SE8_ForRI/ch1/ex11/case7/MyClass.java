package Java_SE8_ForRI.ch1.ex11.case7;

public class MyClass extends I implements J {

    public static void main(String[] args) {

        // #*# There are no conflicts and we don't have to implement the abstract method f() from the interface J
        // because we inherit an implementation for that method from the superclass I
        System.out.println("Method main() from MyClass ");
    }
}
