package lambdaExpressionsPart2;

import lambdaExpressionsPart1.StringUtils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] cars = new String[]{"Honda Civic", "Toyota avensis", "Toyota supra", "Nisan GTR", "Ferrari F1", "Bentley Continental"};


//        2. Method references. On the previous set of exercises, your solutions to the sorting problems looked
//        something like this:
//                • Bullet 1 Arrays.sort(words, (s1,s2) -> someValue);
//                • Bullet 2 Arrays.sort(words, (s1,s2) -> someValue);
//                • Bullet 3 Arrays.sort(words, (s1,s2) -> someValue);
//                • Bullet 4 Arrays.sort(words, (s1,s2) -> { some code;
//                                    some more code;
//                                    even more code;
//                                    return(someValue); }
//                • Bullet 5 Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
//                For that very last example (bullet 5), replace the explicit lambda with a method reference

        // d) Strings that contain "e" first, everything else second
        Arrays.sort(cars, StringUtils::stringThatContainEfirst);
        System.out.println("Strings that contain 'e' first, everything else second - using a method reference:");
        System.out.println(Arrays.asList(cars));
    }

    //3. More method references. Following is some imaginary code; you can get this code by copying
    //method-references.txt from the lambdas-2-exercises project. Change each to use method references
    //sinstead of explicit lambdas. Hint: you can do this without knowing what any of the code does.

//    method1(x, y, d -> Math.cos(d));
//A:  method1(x, y, Math::cos);

//    someList.forEach(entry -> System.out.println(entry));
//A:  someList.forEach(System.out::println);

//    method2(a, b, c, (d1,d2) -> Math.pow(d1,d2));
//A:  method2(a, b, c, Math::pow);

//    someStream.reduce(0, (i1,i2) -> Integer.sum(i1, i2));
//A:  someStream.reduce(0, Integer::sum);

//    method3(foo, bar, (a,b,c) -> Utils.doSomethingWith(a,b,c));
//A:  method3(foo, bar, Utils::doSomethingWith);

//    method4(() -> Math.random());
//A:  method4(Math::random);

}
