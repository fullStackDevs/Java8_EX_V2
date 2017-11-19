package Java_SE8_For_Really_Impatients_CH_1;


import java.util.ArrayList;

public class EX_9 {

    public static void main(String[] args) {
        Apple a1 = new Apple("green",100);
        Apple a2 = new Apple("red",120);
        Apple a3 = new Apple("yellow",50);

        MyCollection<Apple> myCollection = new MyCollection<Apple>();
        myCollection.add(a1);
        myCollection.add(a2);
        myCollection.add(a3);

        myCollection.forEachIf(System.out::println, a -> a.getWeight() > 90);

    }
}
