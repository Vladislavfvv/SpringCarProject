package by.tms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OfferDto {

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Description length must be more then 2", min = 2)
    private String description;

    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Prise must be in format ***.**!", regexp = "[\\d]+\\.[\\d]{2}")
    private String price;

    public OfferDto(String description, String price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
