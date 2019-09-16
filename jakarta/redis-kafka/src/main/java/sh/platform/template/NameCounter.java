package sh.platform.template;

import org.eclipse.jnosql.diana.redis.keyvalue.SortedSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class NameCounter {

    @Inject
    private SortedSet sortedSet;


    public void count(String name) {
        sortedSet.increment(name, 1L);
    }

    public Map<String, Long> getResult() {
        return sortedSet.getRevRanking()
                .stream()
                .collect(Collectors.toMap(e -> e.getMember(),
                        e -> e.getPoints().longValue()));
    }
}
