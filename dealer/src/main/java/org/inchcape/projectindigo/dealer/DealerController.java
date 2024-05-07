package org.inchcape.projectindigo.dealer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealer")
@RequiredArgsConstructor
public class DealerController {

    @Autowired
    private DealerService dealerService;

    public DealerController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    @PostMapping
    public Dealer createDealer(@RequestParam String dealerName){
        return dealerService.createDealer(dealerName);
    }

    @GetMapping
    public List<Dealer> readDealers(){
        return dealerService.readDealers();
    }

    @PutMapping
    public Dealer updateDealer(@RequestParam Integer id, @RequestParam String dealerName){
        return dealerService.updateDealer(id, dealerName);
    }

    @DeleteMapping
    public void deleteDealer(@RequestParam Integer id){
        dealerService.deleteDealer(id);
    }
}
