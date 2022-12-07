package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "customers")
public class Customer{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @NotBlank(message = "Field must not be empty")
//    @Size(message = "Nickname length must be 2 - 16", min = 2, max = 16)
//    private String nickName;
//
//    @NotBlank(message = "Field must not be empty")
//    @Size(message = "Firstname length must be 2 - 16", min = 2, max = 16)
//    private String firstName;
//
//    @NotBlank(message = "Field must not be empty")
//    @Size(message = "Lastname length must be 2 - 16", min = 2, max = 16)
//    private String lastName;
//
//    @NotBlank(message = "Field must not be empty")
//    @Size(message = "Phone number has incorrect length!", min = 13, max = 13)
//    @Pattern(message = "Phone number is incorrect!", regexp = "\\+375[\\d]+")
//    private int phoneNumber;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickname) {
//        this.nickName = nickname;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstname) {
//        this.firstName = firstname;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastname) {
//        this.lastName = lastname;
//    }
//
//    public int getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(int phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
}
