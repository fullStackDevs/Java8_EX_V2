package lambdaExpressionsPart3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringUtils {

    public static List<String> allMatches(List<String> values, Predicate<String> p) {
        List<String> result = new ArrayList<>();
        for(String str : values){
            if(p.test(str)) {
                result.add(str);
            }
        }
        return result;
    }

    public static List<String> transformList(List<String> list, Function<String,String> f) {
        List<String> result = new ArrayList<>();
        for(String str : list){
            result.add(f.apply(str));
        }
        return result;
    }
}
