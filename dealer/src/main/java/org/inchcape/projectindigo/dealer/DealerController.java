package org.inchcape.projectindigo.dealer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealer")
@RequiredArgsConstructor
public class DealerController {

    @Autowired
    private DealerService dealerService;

    @PostMapping
    public Dealer createDealer(@RequestParam String dealerName) {
        return dealerService.createDealer(dealerName);
    }

    @GetMapping
    public List<Dealer> readDealers() {
        return dealerService.readDealers();
    }

    @GetMapping("/{name}")
    public Dealer readDealer(@PathVariable("name") String name) {
        return dealerService.readDealer(name);
    }

    @PutMapping
    public Dealer updateDealer(@RequestParam Integer id, @RequestParam String dealerName) {
        return dealerService.updateDealer(id, dealerName);
    }

    @DeleteMapping
    public void deleteDealer(@RequestParam Integer id) {
        dealerService.deleteDealer(id);
    }
}
