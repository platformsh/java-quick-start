package sh.platform.template;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("logs")
public class CarLogController {

    @Autowired
    private CarLogRepository repository;

    @GetMapping(produces = "application/json")
    public Iterable<CarLog> get() {
        return repository.findAll();
    }

    @GetMapping(value = "{plate}", produces = "application/json")
    public Iterable<CarLog> getHistoric(@PathVariable("plate") String plate) {
        return repository.findByPlate(plate);
    }

    @GetMapping(value = "models/{model}", produces = "application/json")
    public Iterable<CarLog> get(@PathVariable("model") String model) {
        return repository.findByModel(model);
    }

    @GetMapping(value = "status/{status}", produces = "application/json")
    public Iterable<CarLog> get(@PathVariable("status") CarStatus status) {
        return repository.findByStatus(status);
    }
}
