package lambdaExpressionsPart3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

//      1. Make a static method called allMatches. It should take a List of Strings and a
//      Predicate<String>, and return a new List of all the values that passed the test. Test it with several
//      examples.

        List<String> cars = Arrays.asList("Ferrari", "Lincon Navigator", "Nisan Pathfinder", "Nisan Altima", "Pontiac", "Ford Mustang", "bentley continental");

        System.out.println("=== Exercice 1 ===");
        List<String> shortWords = StringUtils.allMatches(cars, s -> s.length() < 8);
        System.out.println("Filtered list that contains only short strings (less than 6 characters): ");
        System.out.println(shortWords);

        List<String> wordsWithB = StringUtils.allMatches(cars, s -> s.contains("b"));
        System.out.println("Filtered list that contains only words with the letter 'b': ");
        System.out.println(wordsWithB);

        List<String> evenLengthWords = StringUtils.allMatches(cars, s -> s.length() % 2 == 0);
        System.out.println("Filtered list that contains only word that have an even number of letters (2, 4, 6..): ");
        System.out.println(evenLengthWords);


//      2. Redo allMatches so it works on any List and associated Predicate, not just on Strings. Verify that
//      your examples from #1 still work. But now, you should be able to also do things like this:
//        • List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
//        • List<Integer> bigNums = ElementUtils.allMatches(nums, n -> n>500);

        System.out.println();
        System.out.println("=== Exercice 2 ===");

        List<Integer> nums = Arrays.asList(1, 100, 1000, 10000, 100000);
        System.out.println("Filtered list that contains only numbers bigger than 5000: ");
        System.out.println(allMatchesUsingGenerics(nums, nr -> nr > 500));

        //Retesting previous examples to see if they still work using the generic method
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("* Rerun exercices from #1 with generic method to see if they still work");
        System.out.println("--------------------------------------------------------------------------");
        List<String> shortWords_2 = allMatchesUsingGenerics(cars, str -> str.length() < 8);
        System.out.println("Car list filtered with generic method to contain only short words: ");
        System.out.println(shortWords_2);

        List<String> wordsWithB_2 = allMatchesUsingGenerics(cars, str -> str.contains("b"));
        System.out.println("Filtered list that contains only words with the letter 'b' within them: ");
        System.out.println(wordsWithB_2);

        System.out.println("Filtered list that contains only words that have an even number of letters: ");
        List<String> evenLinghtWords_2 = allMatchesUsingGenerics(cars, str -> str.length() % 2 == 0);
        System.out.println(evenLinghtWords_2);


//      3. Make a static method called transformedList. It should take a List of Strings and a
//      Function<String,String> and return a new List that contains the results of applying the Function to
//      each element of the original List. E.g.:
//          • List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
//          • List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
//          • List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);

        System.out.println();
        System.out.println("=== Exercice 3 ===");

        System.out.println("List of exciting words: ");
        List<String> excitingWords = StringUtils.transformList(cars, str -> str + "!");
        System.out.println(excitingWords);

        System.out.println("List of transformed words - replaced 'i' with 'eye': ");
        List<String> eyeWords = StringUtils.transformList(cars, str -> str.replace("i", "eye"));
        System.out.println(eyeWords);

        System.out.println("Transformed the words in the list to uppercase: ");
        List<String> upperCaseWords = StringUtils.transformList(cars, str -> str.toUpperCase());
        System.out.println(upperCaseWords);


//      4. Redo transformedList so it works with generic types. Verify that your examples from #3 still work.
//      But now, you should also be able to also do things like this:
//           • List<Integer> wordLengths = ElementUtils.transformedList(words, String::length);
//      Notice above that I am passing in a List of Strings, but getting out a List of Integer. Make sure your
//      generic types support this idea

        System.out.println();
        System.out.println("=== Exercice 4 ===");

        System.out.println("Transformed list with generic method - from words to words length");
        List<Integer> wordsLength = transformList(cars, car ->  car.length());
        System.out.println(wordsLength);

        //Retesting the previous examples to see if the still work with the generic version of the function
        System.out.println("List of exciting words - with generic function: ");
        List<String> excitingWords_builtWithGenericMethod = transformList(cars, str -> str + "!");
        System.out.println(excitingWords_builtWithGenericMethod);

        System.out.println("List of transformed words - replaced 'i' with 'eye' -- using generics");
        List<String> eyeWords_builtWithGenericMethod = transformList(cars, str -> str.replace("i", "eye"));
        System.out.println(eyeWords_builtWithGenericMethod);

        System.out.println("Transformed the words in the list to uppercase - using a generic method: ");
        List<String> upperCaseWwords_builtWithGenericMethod = transformList(cars, str -> str.toUpperCase());
        System.out.println(upperCaseWwords_builtWithGenericMethod);

    }

    public static <T,R> List<R> transformList(List<T> list, Function<T,R> f) {
        List<R> result = new ArrayList<>();
        for(T elem : list) {
            result.add(f.apply(elem));
        }
        return result;
    }

    public static <E> List<E> allMatchesUsingGenerics(List<E> list, Predicate<E> p) {
        List<E> result = new ArrayList<>();
        for(E element : list) {
            if(p.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
