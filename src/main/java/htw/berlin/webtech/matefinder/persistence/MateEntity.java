package htw.berlin.webtech.matefinder.persistence;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "mates")
public class MateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mate_id")
    private Long id;

    @Column(name = "mate_name", nullable = false)
    private String name;

    @Column(name = "mate_price", nullable = false)
    private BigDecimal price;

    public MateEntity(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    protected MateEntity() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}