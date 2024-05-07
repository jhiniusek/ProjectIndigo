package org.inchcape.projectindigo.dealer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DealerService {
    @Autowired
    private DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    public List<Dealer> readDealers(){
        List<Dealer> dealers = dealerRepository.findAll();
        return dealers;
    }

    public Dealer createDealer(String dealerName){
        Dealer dealer = new Dealer();
        dealer.setCreateDate(LocalDateTime.now());
        dealer.setAmendDate(LocalDateTime.now());
        dealer.setDescription(dealerName);
        dealerRepository.save(dealer);
        return dealer;
    }

    public Dealer updateDealer(Integer id, String name){
        Optional<Dealer> dealer = dealerRepository.findById(id);
        dealer.get().setDescription(name);
        dealerRepository.save(dealer.get());
        return dealer.get();
    }

    public void deleteDealer(Integer id){
        dealerRepository.deleteById(id);
    }
}
