package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;



@AllArgsConstructor
@Table(name = "offers")
public class Offer extends AbstractEntity{

    private LocalDateTime offerDateTime;
    private AbstractVehicle vehicle;
    private String description;
    private BigDecimal price;
    @OneToOne
    private Seller seller;

    public Offer() {
        this.offerDateTime = LocalDateTime.now();
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
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

    public AbstractVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(AbstractVehicle vehicle) {
        this.vehicle = vehicle;
    }
}
