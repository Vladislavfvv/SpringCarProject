package by.tms.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@MappedSuperclass
public abstract class AbstractVehicle extends AbstractEntity {


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

    @OneToOne
    private FileUploader fileUpload;

    //@OneToOne
//    private String image;

    public AbstractVehicle(FileUploader fileUploader,
            //String img,
                           String srcPicture, String nameProduct, String color, String producer, String releaseDate, User user) {
        // this.image = img;
        this.fileUpload = fileUploader;
        this.srcPicture = srcPicture;
        this.nameProduct = nameProduct;
        this.color = color;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.user = user;
    }

    public FileUploader getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(FileUploader fileUploader) {
        this.fileUpload = fileUploader;
    }

    public AbstractVehicle() {
    }

    public AbstractVehicle(String srcPicture, String nameProduct, String color, String producer, String releaseDate) {
        this.srcPicture = srcPicture;
        this.nameProduct = nameProduct;
        this.color = color;
        this.producer = producer;
        this.releaseDate = releaseDate;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

//    public ImageUpload getImage() {
//        return image;
//    }
//
//    public void setImage(ImageUpload image) {
//        this.image = image;
//    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
