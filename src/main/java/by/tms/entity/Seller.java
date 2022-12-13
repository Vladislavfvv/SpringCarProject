package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "sellers")
public class Seller extends User{


    @NotBlank(message = "Field must not be empty")
    @Size(message = "Company's name length must be 2 - 16", min = 2, max = 16)
    private String companyName;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Phone number has incorrect length!", min = 13, max = 13)
    @Pattern(message = "Phone number is incorrect!", regexp = "\\+375[\\d]+")
    private String phoneNumber;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Store address length must be 2 - 150", min = 2, max = 150)
    private String storeAddress;

    //@NotNull
    @ElementCollection
    @Size(min = 1, max = 5)
    private List<String> productCategories;

    public Seller() {
    }

    public Seller(@NotBlank(message = "Field must not be empty")
                  @Email String email,
                  @NotBlank(message = "Field must not be empty")
                  @Size(message = "Password length must be 5-10 characters!", min = 5, max = 10)
                  @Pattern(message = "Password must consist of numbers and latin letters!", regexp = "[\\w\\d]+")
                  String password) {
        super(email, password);
    }

    public Seller(@NotBlank(message = "Field must not be empty") @Email String email, @NotBlank(message = "Field must not be empty") @Size(message = "Password length must be 5-10 characters!", min = 5, max = 10) @Pattern(message = "Password must consist of numbers and latin letters!", regexp = "[\\w\\d]+") String password, String companyName, String phoneNumber, String storeAddress) {
        super(email, password);
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.storeAddress = storeAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}
