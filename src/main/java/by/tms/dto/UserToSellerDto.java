package by.tms.dto;

import by.tms.entity.User;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserToSellerDto {
    private User user;

   // @NotNull
    @ElementCollection
    @Size(min = 1, max = 5)
    private List<String> productCategories;

    public UserToSellerDto() {
    }

    public UserToSellerDto(User user, List<String> productCategories) {
        this.user = user;
        this.productCategories = productCategories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<String> productCategories) {
        this.productCategories = productCategories;
    }


}
