package sh.platform.template;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("people")
public class PersonController {

    @Autowired
    private PersonRepository repository;


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<String> save(@RequestBody Person person) {
        repository.save(person);
        return Mono.just("Saved- " + person.getName());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Mono<Person> get(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    @GetMapping(produces = "application/json")
    public Flux<Person> get() {
        return repository.findAll();
    }


    @PutMapping(value = "/{id}", produces = "application/json")
    public Mono<Person> update(@PathVariable("id") long id, @RequestBody Person person) {
        repository.save(person);
        return Mono.just(person);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Mono<Person> delete(@PathVariable("id") long id) {
        return repository.findById(id);
    }
}
