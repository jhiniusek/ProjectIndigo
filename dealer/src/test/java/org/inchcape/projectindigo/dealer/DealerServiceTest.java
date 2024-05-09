package org.inchcape.projectindigo.dealer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class DealerServiceTest {

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private DealerRepository dealerRepository;
    @InjectMocks
    private DealerService dealerService;

    @Test
    void getAllDealersTest(){
        Dealer dealer= new Dealer();
        dealerRepository.save(dealer);
        Dealer dealer2= new Dealer();
        dealerRepository.save(dealer2);

        given(dealerRepository.findAll()).willReturn(List.of(dealer,dealer2));
        List<Dealer> dealerList = dealerService.readDealers();

        assertThat(dealerList).isNotNull();
        assertThat(dealerList.size()).isEqualTo(2);
    }

    @Test
    void createDealerTest(){
        Dealer mockDealer = dealerService.createDealer("TeslaMockit");

        verify(dealerRepository).save(mockDealer);
    }

    @Test
    void getDealerTest(){
        Dealer dealer= new Dealer();
        dealer.setDescription("TeslaMockit");
        dealerRepository.save(dealer);

        given(dealerRepository.findDealerByName("TeslaMockit")).willReturn(dealer);
        var testDealer = dealerService.readDealer("TeslaMockit");

        assertThat(testDealer).isNotNull();
        assertThat(testDealer.getDescription()).isEqualTo("TeslaMockit");
    }

    @Test
    void updateDealerTest(){
        Dealer testDealer = dealerService.createDealer("TeslaMockit");

        given(dealerRepository.findById(1)).willReturn(Optional.ofNullable(testDealer));
        dealerService.updateDealer(1, "LexusMockit");

        assertThat(testDealer).isNotNull();
        assert testDealer != null;
        assertThat(testDealer.getDescription()).isEqualTo("LexusMockit");
    }

    @Test
    void deleteDealerTest(){
        Dealer testDealer = dealerService.createDealer("TeslaMockit");

        given(dealerRepository.findById(1)).willReturn(Optional.ofNullable(testDealer));

        dealerService.deleteDealer(1);

        verify(dealerRepository).deleteById(1);
    }
}
