package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
public class AbstractMotorVehicle extends AbstractVehicle{

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Engine type must contain one of the names: gasoline, diesel, hydrogen, wood, electricity", min = 4, max = 11)
    private String engine;
}
