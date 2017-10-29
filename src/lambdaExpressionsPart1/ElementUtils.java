package lambdaExpressionsPart1;

public class ElementUtils {

    //***!!!***
    //In order to create a static generic function we have to declare the generic type in the function before the return type
    //not at the class declaration (like ElementUtils<T>)
    //***!!!***

    public static <T> T betterElement(T elem1, T elem2, BetterElementPredicate<T> betterElementPredicate){
        T result = null;
        if(betterElementPredicate.test(elem1, elem2)){
            result = elem1;
        } else {
            result = elem2;
        }
        return result;
    }
}
