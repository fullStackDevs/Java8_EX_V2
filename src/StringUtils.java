
public class StringUtils {

    public static int stringThatContainEfirst(String str1, String str2) {
        int result  = 0;
        if(str1.contains("e") && !str2.contains("e")) {
            result = -1;
        } else if(!str1.contains("e") && str2.contains("e")) {
            result = 1;
        }
        return result;
    }
}
