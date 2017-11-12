package lambdaExpressionsPart4;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "bye", "goodbye");

        String wordThatContainsO = words.stream()
                .filter(word -> word.contains("o"))
                .findFirst()
                .orElse(null);

        System.out.println("The first word found in the list that contains 'o' is: " + wordThatContainsO);

        String wordLongerThan5Characters = words.stream()
                .filter(word -> word.length() > 5)
                .findFirst()
                .orElse(null);

        System.out.println("The first word in the list that is longer than 5 characters: " + wordLongerThan5Characters );

        //========================================================================================================================

//        2. Using the and method of Predicate [hard!]. Now, the point of all of this is that filter takes a single
//        Predicate, not multiple Predicates. The goal of this problem is to make filtering more flexible by
//        making similar filtering code, but that accepts any number of Predicates instead of a single Predicate.
//                To accomplish this, first make a method called allPassPredicate that accepts any number of
//        generically typed Predicates (recall how to use varargs with “...”), and returns a single Predicate
//        that tests if the argument passes all of the input Predicates. Second, make a method called firstAllMatch
//        that takes a Stream and any number of correspondingly-typed Predicates, and returns the
//        first entry that matches all of the Predicates. Your code will simply make the combined Predicate,
//        then call code like that at the top of the page. For example, if words is a List<String>, the following
//        would find the first word that both contains an “o” and has length greater than 5.
//        FunctionUtils.firstAllMatch(words.stream(),
//                word -> word.contains("o"),
//                word -> word.length() > 5);

        System.out.println("+++ Exercice 2 ===");

        Predicate<String> p1 = word -> word.contains("o");
        Predicate<String> p2 = word -> word.length() > 5;
        String firstAllMathcResult = FunctionUtils.firstAllMatch(words.stream(), p1, p2);
        System.out.println("The first word in the stream that contains 'o' and is longer than 5 is: " + firstAllMathcResult);


        //=======================================================================================================================

//        3. Using the or method of Predicate [easy if you got problem 2]. Make a method called anyPassPredicate
//        that accepts any number of generically typed Predicates, and returns a single Predicate
//        that tests if the argument passes any of the input Predicates. Then, make a method called
//        firstAnyMatch that takes a Stream and any number of correspondingly-typed Predicates, and
//        returns the first entry that matches any of the Predicates. For example, if words is a List<String>,
//                the following would find the first word that either contains an “o” or has length greater than 5.
//        FunctionUtils.firstAnyMatch(words.stream(),
//                word -> word.contains("o"),
//                word -> word.length() > 5);

        System.out.println();
        System.out.println("=== Exercice 4 ===");
        Predicate<String> p3 = word -> word.contains("u");
        Predicate<String> p4 = word -> word.length() > 4;
        String firstAnyMatchResult = FunctionUtils.firstAnyMatch(words.stream(), p3, p4);
        System.out.println("First element in the stream that contains 'u' or is longer than 4 is (or both): " + firstAnyMatchResult);

    }

}
