package sh.platform.demo.heroes.queries;

import java.util.Collections;
import java.util.HashSet;

public final class Sets {

    private Sets() {
    }

    public static <E> HashSet<E> newHashSet(E... elements) {
        HashSet<E> set = new HashSet<>(elements.length);
        Collections.addAll(set, elements);
        return set;
    }
}
