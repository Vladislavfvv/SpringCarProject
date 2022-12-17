package by.tms.entity;

import javax.persistence.*;

@Entity
public class ImageUpload extends AbstractEntity{

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

//    @OneToOne
//    private Car car;

    public ImageUpload() {
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
