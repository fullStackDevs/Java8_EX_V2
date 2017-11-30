package Java_SE8_ForRI.ch1.ex11.case8;

public class MyClass extends I implements J {

    public static void main(String[] args) {

        // #*# There are no conflicts because of the rule: "superclasses win"

        System.out.println("Method main() from MyClass");

        // #*# If a superclass provides a concrete implementation, the default methods with the same name and
        // parameter types are ignored
        MyClass myClass = new MyClass();
        myClass.f();
    }

}
