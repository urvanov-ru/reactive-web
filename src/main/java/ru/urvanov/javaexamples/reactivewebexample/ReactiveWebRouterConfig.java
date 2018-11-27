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

/**
 * @author Fedor Urvanov
 *
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ReactiveWebRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(ConcatenateHandler concatenateHandler) {

        // We listen /concatenate and return our Concatenate Handler
        return RouterFunctions
                .route(RequestPredicates.GET("/concatenate")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        concatenateHandler::hello);
    }
}
