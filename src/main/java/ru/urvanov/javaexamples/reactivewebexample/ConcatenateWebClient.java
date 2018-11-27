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
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * @author Fedor Urvanov
 *
 */
public class ConcatenateWebClient {

    public String getResult(String str1, String str2) {
        Mono<ClientResponse> result = WebClient.create().get().uri(builder -> builder.scheme("http")
                .host("localhost").port(8080).path("concatenate")
                .queryParam("str1", str1)
                .queryParam("str2", str2)
                .build()).accept(MediaType.TEXT_PLAIN).exchange();
            return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
    
    public static void main(String[] args) {
        ConcatenateWebClient webClient = new ConcatenateWebClient();
        System.out.println(webClient.getResult("Vasya", "Petya"));
    }

}
