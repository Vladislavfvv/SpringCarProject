package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public abstract class AbstractProduct extends AbstractEntity {

    @NotBlank(message = "Field must not be empty")
    //@Pattern(message = "Must be src link", regexp = "https:.+\\.[\\w]{3,4}")
    @URL
    private String srcPicture;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Product name length must be greater than 2", min = 2)
    private String nameProduct;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Product color length must be greater than 3", min = 3)
    private String color;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Producer length must be more then 2", min = 2)
    private String producer;

    @Pattern(message = "Must be year of release", regexp = "\\d+")
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must be year of release", min = 4, max = 4)
    private String releaseDate;
    @ManyToOne
    private User user;

//    @ManyToOne
//    private Category category;

//    public AbstractProduct(String srcPicture, String nameProduct, String color, String producer, String releaseDate) {
//        super();
//    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AbstractProduct() {
    }

    public AbstractProduct(String srcPicture, String nameProduct, String color, String producer, String releaseDate, User user) {
        this.srcPicture = srcPicture;
        this.nameProduct = nameProduct;
        this.color = color;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.user = user;
    }

    public String getSrcPicture() {
        return srcPicture;
    }

    public void setSrcPicture(String srcPicture) {
        this.srcPicture = srcPicture;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
