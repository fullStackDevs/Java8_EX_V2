package lambdaExpressionsPart4;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionUtils {

    public static <T> Predicate<T> allPassPredicate(Predicate<T>... predicates){
        Predicate<T> combinedPredicates = predicates[0];
        for(int i = 1; i < predicates.length; i++){
            combinedPredicates = combinedPredicates.and(predicates[i]);
        }
        return combinedPredicates;
    }

    public static <T> T firstAllMatch(Stream<T> stream, Predicate<T>... predicates) {
        Predicate<T> combinedPredicates = allPassPredicate(predicates);
        return stream
                .filter(combinedPredicates)
                .findFirst()
                .orElse(null);
    }

    public static <T> Predicate<T> anyMatchPredicate(Predicate<T>... predicates) {
        Predicate<T> combinedPredicates = predicates[0];
        for (int i = 1; i < predicates.length; i++) {
            combinedPredicates = combinedPredicates.or(predicates[i]);
        }
        return combinedPredicates;
    }

    public static <T> T firstAnyMatch(Stream<T> stream, Predicate<T>... predicates) {
        Predicate<T> combinedPredicates = anyMatchPredicate(predicates);
        return stream
                .filter(combinedPredicates)
                .findFirst()
                .orElse(null);
    }
}
