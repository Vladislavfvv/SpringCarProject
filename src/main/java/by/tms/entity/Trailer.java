package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Trailer extends AbstractProduct {
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must contain 1 to 20", min = 1, max = 20)
    private int carryingCapacity;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must contain 1 to 4", min = 1, max = 4)
    private int countOfAxles;
}
