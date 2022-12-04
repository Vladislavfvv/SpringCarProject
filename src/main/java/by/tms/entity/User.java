package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {
    @NotBlank(message = "Field must not be empty")
    @Email
    private String email;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Password length must be 5-10 characters!", min = 5, max = 10)
    @Pattern(message = "Password must consist of numbers and latin letters!", regexp = "[\\w\\d]+")
    private String password;

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
}
