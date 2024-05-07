package org.inchcape.projectindigo.dealer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DealerRepository extends JpaRepository<Dealer, Integer> {
    @Query(value = "SELECT * FROM dealer WHERE description LIKE ?1", nativeQuery = true)
    Dealer findDealerByName(String name);
}
