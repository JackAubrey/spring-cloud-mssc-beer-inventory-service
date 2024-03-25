package guru.sfg.brewery.model.events;

import guru.sfg.brewery.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllocateBeerOrderResult {
    private BeerOrderDto beerOrderDto;
    @Builder.Default
    private Boolean allocationError = false;
    @Builder.Default
    private Boolean pendingInventory = false;
}
