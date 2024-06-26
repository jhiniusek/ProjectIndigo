package org.inchcape.projectindigo.dealer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DealerService {
    @Autowired
    private DealerRepository dealerRepository;

    public List<Dealer> readDealers() {
        return dealerRepository.findAll();
    }

    public Dealer readDealer(String name) {
        return dealerRepository.findDealerByName(name);
    }

    public Dealer createDealer(String dealerName) {
        Dealer dealer = new Dealer();
        dealer.setCreateDate(LocalDateTime.now());
        dealer.setAmendDate(LocalDateTime.now());
        dealer.setDescription(dealerName);
        dealerRepository.save(dealer);
        return dealer;
    }

    public Dealer updateDealer(Integer id, String name) {
        Optional<Dealer> dealer = dealerRepository.findById(id);
        if (dealer.isPresent()) {
            dealer.get().setDescription(name);
            dealer.get().setAmendDate(LocalDateTime.now());
            dealerRepository.save(dealer.get());
            return dealer.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Dealer not found"
            );
        }

    }

    public void deleteDealer(Integer id) {
        dealerRepository.deleteById(id);
    }
}
