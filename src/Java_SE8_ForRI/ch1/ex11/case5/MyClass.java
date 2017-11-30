package Java_SE8_ForRI.ch1.ex11.case5;


// *#* This class was mad abstract only to be able to run the other classes in the project
// In this test case the "abstract" modifier should be deleted
public abstract class MyClass implements I, J{

   //#*# This class does not have to provide an implementation for the abstract method in the interface I
   // because it inherits an implementation for that method from the interface J that has a static method
   // with the same name and signature


    public static void main(String[] args) {
        //MyClass myClass = new MyClass();
        //myClass.testMethod();
    }

    void testMethod() {

        // #*# We are able to call this method here because we inherit the method f() from interface I
        // and the implementation used for this method is taken from J - it's like we would override it in the class
        f();
    }

//    public void f() {
//        System.out.println("Overridden f() method in the class MyClass");
//    }

}
