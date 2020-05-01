package sh.platform.template;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> hello() {
        return Mono.just("Hello World Spring Boot using Platform.sh");
    }
}
