package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity {

    @NotBlank(message = "Field must not be empty")
    @Size(message = "First name length must be 2 - 16", min = 2, max = 16)
    @Pattern(message = "First name must consist of latin letters!", regexp = "[a-zA-Z]*")
    private String firstName;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Second name length must be 2 - 16", min = 2, max = 16)
    @Pattern(message = "Second name must consist of latin letters!", regexp = "[a-zA-Z]*")
    private String secondName;
    @NotBlank(message = "Field must not be empty")
    @Email
    private String email;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Phone number has incorrect length!", min = 13, max = 13)
    @Pattern(message = "Phone number is incorrect!", regexp = "\\+375[\\d]+")
    private String phone;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Store address length must be 2 - 150", min = 2, max = 150)
    private String address;


    @NotBlank(message = "Field must not be empty")
    @Size(message = "Password length must be 5-10 characters!", min = 5, max = 10)
    @Pattern(message = "Password must consist of numbers and latin letters!", regexp = "[\\w\\d]+")
    private String password;

    @OneToMany
    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    //    public List<Offer> getOfferList() {
//        return offerList;
//    }
//
//    public void setOfferList(List<Offer> offerList) {
//        this.offerList = offerList;
//    }
//
//    @OneToMany
//    private List<Offer> offerList;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String secondName, String email, String phone, String address, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;

    }

    public User(String firstName, String secondName, String email, String phone, String address, String password,
                //List<Offer> offerList
                List<Car> carList ) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        //this.offerList = offerList;
        this.carList = carList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    //    @Override
//    public String toString() {
//        return "User{" +
//                "firstName='" + firstName + '\'' +
//                ", secondName='" + secondName + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", address='" + address + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
