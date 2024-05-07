package org.inchcape.projectindigo.dealer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "dealer")
public class Dealer {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "amend_date")
    private LocalDateTime amendDate;

    @Column(name = "description")
    private String description;

}