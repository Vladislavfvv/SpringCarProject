package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Vehicle extends AbstractProduct{
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Product color length must be greater than 3", min = 3)
    private String color;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must contain 1 to 1500 km/h", min = 1, max = 1500)
    private int maxSpeed;
}
