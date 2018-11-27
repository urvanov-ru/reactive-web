/**
 * <p>
 * <a href="https://urvanov.ru>https://urvanov.ru</a>
 * </p>
 * <p>
 * <b>LICENSE:</b>
 * </p>
 * <p>
 * Do what you want.
 * </p>
 */
package ru.urvanov.javaexamples.reactivewebexample;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * @author Fedor Urvanov
 *
 */
@Component
public class ConcatenateHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters
                        .fromObject(request.queryParam("str1").orElse("")
                                + request.queryParam("str2").orElse("")));
    }

}
