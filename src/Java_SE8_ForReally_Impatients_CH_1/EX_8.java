package Java_SE8_ForReally_Impatients_CH_1;

import java.util.ArrayList;
import java.util.List;

public class EX_8 {

    public static void main(String[] args) {

//      8. What happens when a lambda expression captures values in an enhanced
//      for loop such as this one?

        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();

        for (String name : names) {
            //name += "s";
            runners.add(() -> System.out.println(name));
        }

        System.out.println("The size of the list 'runners' is: " + runners.size());

//============================================================================================================
        //Check to see if it works wit other types of objects

        Apple a1 = new Apple("green", 75);
        Apple a2 = new Apple("red", 80);
        Apple a3 = new Apple("yello", 100);
        List<Runnable> runnableApples = new ArrayList<>();

        Apple[] apples = {a1, a2, a3};
        for(Apple a : apples) {
            runnableApples.add(() -> System.out.println(a.getColor()));
        }


//============================================================================================================

//      Is it legal? Does each lambda expression capture a different value, or do they
//      all get the last value? What happens if you use a traditional loop for (int i = 0; i < names.length; i++)?

        List<Runnable> runners2 = new ArrayList<>();
        for(int i = 0; i < names.length; i++) {
            //#!!!# - The below line will thorw an error because the local variable "i" is not final or
            //effectively final and it is used in a lambda expression
            //runners2.add(() -> System.out.println(names[i]));
        }


    }
}
