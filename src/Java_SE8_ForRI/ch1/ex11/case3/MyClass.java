package Java_SE8_ForRI.ch1.ex11.case3;


public class MyClass extends Zclass implements I, J{

    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        myClass.asd();
        MyClass.asd();

        // #*# The below line throws an error (cannot find symbol)
        //myClass.f();
        // #*# It also throws an error for the below line
        //MyClass.f();
        I.f();
        J.f();

    }

    private void test() {
        this.asd();

        // #*# for the below line we get an error
        //f();
    }
}
