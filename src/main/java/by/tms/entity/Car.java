package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car extends AbstractProduct {

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must contain 1 to 5", min = 1, max = 5)
    private int passengerCapacity;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must contain 1 to 1500 km/h", min = 1, max = 1500)
    private int maxSpeed;

}
