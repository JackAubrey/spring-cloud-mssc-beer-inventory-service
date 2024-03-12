package guru.sfg.beer.inventory.service.services;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.brewery.model.BeerDto;
import guru.sfg.brewery.model.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class NewInventoryListeners {
    private final BeerInventoryRepository beerInventoryRepository;
    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(@Payload NewInventoryEvent eventMessage) {
        log.info("Received New Inventory Event: {}", eventMessage);
        BeerDto beerDto = eventMessage.getBeerDto();
        BeerInventory beerInventory = BeerInventory.builder()
                .upc(beerDto.getUpc())
                .beerId(beerDto.getId())
                .quantityOnHand(beerDto.getQuantityOnHand())
                .build();
        beerInventoryRepository.save(beerInventory);
    }
}
