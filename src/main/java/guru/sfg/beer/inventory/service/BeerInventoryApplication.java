package guru.sfg.beer.inventory.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Hooks;

@SpringBootApplication(scanBasePackages = {"guru.sfg.beer.common", "guru.sfg.beer.inventory"})
public class BeerInventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeerInventoryApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initHook() {
        Hooks.enableAutomaticContextPropagation();
    }
}
