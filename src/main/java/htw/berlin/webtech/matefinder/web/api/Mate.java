package htw.berlin.webtech.matefinder.web.api;

import htw.berlin.webtech.matefinder.persistence.RatingEntity;

import java.math.BigDecimal;
import java.util.List;

public class Mate {

    private final int id;
    private String name;
    private BigDecimal price;
    private List<RatingEntity> ratings;

    public Mate(int id, String name, BigDecimal price, List<Integer> ratingIds) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
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

    public List<RatingEntity> getRatings() { return ratings; }
}
