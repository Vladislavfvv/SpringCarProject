package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "cars")
public class Car extends AbstractProduct {

    @NotNull(message = "Field must not be empty")
//    @Size(message = "Must contain 1 to 5", min = 1, max = 5)
    private int passengerCapacity;

    public Car() {
    }

    public Car(String srcPicture, String nameProduct, String color, String producer, String releaseDate, User user, int passengerCapacity) {
        super(srcPicture, nameProduct, color, producer, releaseDate, user);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

//    @Override
//    public String toString() {
//        return "Car{" +
//                "passengerCapacity=" + passengerCapacity +
//                "name=" + getNameProduct() +
//                "color=" + getColor() +
//                "producer=" + getProducer() +
//                "release date=" + getReleaseDate() +
//                "picture=" + getSrcPicture() +
//                "id=" + getId() +
//                '}';
//    }
}
