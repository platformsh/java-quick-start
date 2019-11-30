package sh.platform.demo.heroes.queries;

import jakarta.nosql.document.DocumentDeleteQuery;
import jakarta.nosql.document.DocumentQuery;
import jakarta.nosql.mapping.document.DocumentTemplate;
import sh.platform.demo.heroes.Hero;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jakarta.nosql.document.DocumentDeleteQuery.delete;
import static jakarta.nosql.document.DocumentQuery.select;

@ApplicationScoped
public class FluentAPIFindAllService {

    @Inject
    private DocumentTemplate template;

    public void execute() {

        Hero iron = new Hero("Iron man", 32, Sets.newHashSet("Rich"));
        Hero thor = new Hero("Thor", 5000, Sets.newHashSet("Force", "Thunder"));
        Hero captainAmerica = new Hero("Captain America", 80, Sets.newHashSet("agility",
                "strength", "speed", "endurance"));
        Hero spider = new Hero("Spider", 18, Sets.newHashSet("Spider"));

        DocumentDeleteQuery deleteQuery = delete().from("Hero")
                .where("_id").in(Stream.of(iron, thor, captainAmerica, spider)
                        .map(Hero::getName).collect(Collectors.toList())).build();
        template.delete(deleteQuery);
        template.insert(Arrays.asList(iron, thor, captainAmerica, spider));

        DocumentQuery query = select()
                .from("Hero")
                .build();

        Stream<Hero> heroes = template.select(query);
        Stream<Hero> peek = heroes.peek(System.out::println);
        System.out.println("The peek is not happen yet");
        System.out.println("The Heroes names: " + peek.map(Hero::getName)
                .collect(Collectors.joining(", ")));

        DocumentQuery querySkipLimit = select()
                .from("Hero")
                .skip(0)
                .limit(1)
                .build();

        Stream<Hero> heroesSkip = template.select(querySkipLimit);
        System.out.println("The Heroes names: " + heroesSkip.map(Hero::getName)
                .collect(Collectors.joining(", ")));
    }
}
