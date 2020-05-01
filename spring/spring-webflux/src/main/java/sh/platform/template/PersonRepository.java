package sh.platform.template;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {


    private Map<Long, Person> data = new HashMap<>();

    public void save(Person person) {
        data.put(person.getId(), person);
    }

    public Mono<Person> findById(long id) {
        return Mono.just(data.get(id));
    }

    public Flux<Person> findAll() {
        return Flux.fromIterable(data.values());
    }

    public void deleteById(long id) {
        data.remove(id);
    }
}