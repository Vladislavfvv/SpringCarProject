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
@Table(name = "buses")
public class Bus extends AbstractMotorVehicle{


    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must contain 1 to 30", min = 1, max = 30)
    private int passengerCapacity;

}
