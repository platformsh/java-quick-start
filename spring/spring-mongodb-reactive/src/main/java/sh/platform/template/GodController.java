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
@RequestMapping("gods")
public class GodController {

    @Autowired
    private GodRepository repository;


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<String> save(@RequestBody God god) {
        return repository.save(god).map(g -> "Saved: " + g.getName());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Mono<God> get(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @GetMapping(produces = "application/json")
    public Flux<God> get() {
        return repository.findAll();
    }


    @PutMapping(value = "/{id}", produces = "application/json")
    public Mono<God> update(@PathVariable("id") long id, @RequestBody God god) {
        repository.save(god);
        return Mono.just(god);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Mono<God> delete(@PathVariable("id") String id) {
        return repository.findById(id);
    }
}
