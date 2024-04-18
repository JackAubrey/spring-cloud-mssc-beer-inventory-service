package guru.sfg.beer.inventory.service.config.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@Slf4j
public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("URI: {}", request.getURI());
        log.info("HTTP Method: {}", request.getMethod());
        log.info("HTTP Headers: {}", request.getHeaders());
        System.out.println("URI: "+request.getURI());
        System.out.println("HTTP Method: "+request.getMethod());
        System.out.println("HTTP Headers: "+request.getHeaders());
        return execution.execute(request, body);
    }
}
