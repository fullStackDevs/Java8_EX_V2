package Java_SE8_ForReally_Impatients_CH_1;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T> {

    default void forEachIf(Consumer<T> action, Predicate<T> p) {
        for(T t : this) {
            if(p.test((T)t)) {
                action.accept((T)t);
            }
        }
    }

}
