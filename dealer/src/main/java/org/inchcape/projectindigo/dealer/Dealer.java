package org.inchcape.projectindigo.dealer;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dealer")
public class Dealer {
    @Id
    @Column(name="actor_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="amend_date")
    private Date amendDate;

    @Column(name="description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAmendDate() {
        return amendDate;
    }

    public void setAmendDate(Date amendDate) {
        this.amendDate = amendDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
