package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address extends AbstractEntity{

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Country length must be 3 - 20", min = 3, max = 20)
    private String country;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "City length must be 3 - 20", min = 3, max = 20)
    private String city;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Street length must be 2 - 20", min = 2, max = 20)
    private String street;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
