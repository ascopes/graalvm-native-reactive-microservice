package io.ascopes.helloworld;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class HelloWorldController {
    @Data
    public static final class HelloMessage {
        private final String message;
    }

    @GetMapping("/hello/{name}")
    public Mono<HelloMessage> sayHello(@PathVariable String name) {
        return Mono.just(new HelloMessage("Hello, " + name));
    }
}
