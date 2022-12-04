package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractVehicle extends AbstractEntity {

    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Must be src link", regexp = "https:.+\\.[\\w]{3,4}")
    private String srcPicture;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Vehicle name length must be greater than 2", min = 2)
    private String nameVehicle;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Vehicle color length must be greater than 3", min = 3)
    private String color;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Producer length must be more then 2", min = 2)
    private String producer;


    @Pattern(message = "Must be year of release", regexp = "\\d+")
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must be year of release", min = 4, max = 4)
    private String releaseDate;

    public String getSrcPicture() {
        return srcPicture;
    }

    public void setSrcPicture(String srcPicture) {
        this.srcPicture = srcPicture;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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
}
