package by.tms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends AbstractVehicle {


    @NotNull(message = "Field must not be empty")
//    @Size(message = "Must contain 1 to 5", min = 1, max = 5)
    private int passengerCapacity;

    public Car() {
    }

    public Car(FileUploader fileUploader, String srcPicture, String nameProduct, String color, String producer, String releaseDate, User user, int passengerCapacity) {
        super(fileUploader, srcPicture, nameProduct, color, producer, releaseDate, user);
        this.passengerCapacity = passengerCapacity;
    }

    public Car(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Car(String srcPicture, String nameProduct, String color, String producer, String releaseDate, int passengerCapacity) {
        super(srcPicture, nameProduct, color, producer, releaseDate);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }


}
