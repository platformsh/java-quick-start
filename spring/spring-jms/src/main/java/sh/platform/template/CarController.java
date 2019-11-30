package sh.platform.template;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarRepository repository;

    @Autowired
    private JmsTemplate template;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String save(@RequestBody Car car) {
        repository.save(car);
        template.convertAndSend("new", car);
        return "Saved- " + car.getModel();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Car get(@PathVariable("id") long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @GetMapping(produces = "application/json")
    public Iterable<Car> get() {
        return repository.findAll();
    }


    @PutMapping(value = "/{id}", produces = "application/json")
    public Car update(@PathVariable("id") long id, @RequestBody Car car) {
        repository.save(car);
        return car;
    }

    @DeleteMapping(value = "junk/{id}", produces = "application/json")
    public Car junk(@PathVariable("id") long id) {
        Car car = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        repository.deleteById(id);
        template.convertAndSend("junk", car);
        return car;
    }

    @DeleteMapping(value = "sold/{id}", produces = "application/json")
    public Car sold(@PathVariable("id") long id) {
        Car car = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        repository.deleteById(id);
        template.convertAndSend("sold", car);
        return car;
    }
}
