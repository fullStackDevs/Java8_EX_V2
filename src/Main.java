import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //--------------------------------------
        //EXERCICES: Lambda Expressions Part 1
        //--------------------------------------


        String[] cars = new String[]{"Honda Civic", "Toyota avensis", "Toyota supra", "Nisan GTR", "Ferrari F1", "Bentley Continental"};

        //EX 1: Sort the array
        //------------------------

        //a) By length (shortest to longest)
        Arrays.sort(cars, (car1, car2) -> car1.length() - car2.length());
        System.out.println("Array sorted by car name length ascending: " + Arrays.asList(cars));

        //b) By Length (longest to shortest)
        Arrays.sort(cars, (car1, car2) -> car2.length() - car1.length());
        System.out.println("Array sorteb by car name length descending: "  + Arrays.asList(cars));

        //c) Alphabeticall by the first character only
        Arrays.sort(cars, (car1, car2) -> car1.charAt(0) - car2.charAt(0));
        System.out.println("Array sorted alphabetically by the first character only: " + Arrays.asList(cars));

        //d) Strings that contain "e" first, everyting else second
        Arrays.sort(cars, (car1, car2) -> {
            int result =0;
            if(car1.contains("e") && !car2.contains("e")){
                result = -1;
            } else if(!car1.contains("e") && car2.contains("e")){
                result = 1;
            }
            return result;
        });
        System.out.println("Array in which the car names that contain 'e' are first and everytihg else is second: "  + Arrays.asList(cars));

        //d) Same as previous sorting criteria but using a static method from another class
        Arrays.sort(cars, (car1, car2) -> StringUtils.stringThatContainEfirst(car1, car2));
        System.out.println("Array in which the car names that contain 'e' are first and everything else is second: " + Arrays.asList(cars));


        //============================================================================================================================================
        //============================================================================================================================================

        //EX 2 : Making your own interfaces for which lambdas can be used. Your eventual goal is to make a
        //method called betterString that takes two Strings and a lambda that says whether the first of the two
        //is “better”. The method should return that better String; i.e., if the function given by the lambda
        //returns true, the betterString method should return the first String, otherwise betterString should
        //return the second String.
        //--------------------------------------------------------------------------------------------------------

        System.out.println("The better string between 'building' and 'htight' is: ");
        System.out.println(betterString("Building", "height", (s1, s2) -> s1.length() > s2.length()));

        System.out.println("The better sting between 'Ferrary' and 'Bentley' is ");
        System.out.println(betterString("Ferrary", "Bentley", (s1, s2) -> s1.contains("B")));

    }

    public static String betterString(String s1, String s2, TwoStringsPredicate twoStringsPredicate){
        String result = "";
        if(twoStringsPredicate.test(s1, s2)){
            result = s1;
        } else {
            result = s2;
        }
        return result;
    }
}
