package by.tms.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer extends AbstractEntity {

    private LocalDateTime offerDateTime;

    @ManyToOne//(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", nullable = false)
    private AbstractProduct abstractProduct;
    private String description;
    private BigDecimal price;

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public Offer() {
        this.offerDateTime = LocalDateTime.now();
    }

    public Offer(LocalDateTime offerDateTime, AbstractProduct abstractProduct, String description, BigDecimal price, User user) {
        this.offerDateTime = offerDateTime;
        this.abstractProduct = abstractProduct;
        this.description = description;
        this.price = price;
        this.user = user;
    }

    public LocalDateTime getOfferDateTime() {
        return offerDateTime;
    }

    public void setOfferDateTime(LocalDateTime offerDateTime) {
        this.offerDateTime = offerDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public void setUser(User user) {
        this.user = user;
    }

    public AbstractProduct getAbstractProduct() {
        return abstractProduct;
    }

    public void setAbstractProduct(AbstractProduct abstractProduct) {
        this.abstractProduct = abstractProduct;
    }
}
