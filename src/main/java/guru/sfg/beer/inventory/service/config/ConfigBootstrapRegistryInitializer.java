package guru.sfg.beer.inventory.service.config;

import guru.sfg.beer.inventory.service.config.interceptors.CustomClientHttpRequestInterceptor;
import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class ConfigBootstrapRegistryInitializer implements BootstrapRegistryInitializer {

    @Override
    public void initialize(BootstrapRegistry registry) {
        registry.register(RestTemplate.class, context -> {
            RestTemplate restTemplate = new RestTemplateBuilder().interceptors(new CustomClientHttpRequestInterceptor())
                    .build();
            return restTemplate;
        });
    }
}
