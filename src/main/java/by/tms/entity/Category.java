package by.tms.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Entity
public class Category extends AbstractEntity {

//    @NotBlank(message = "Field must not be empty")
//    @Size(message = "Product name length must be greater than 2", min = 2)
    private String nameCategory;

    @OneToMany
    private List<AbstractProduct> abstractProductList;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<AbstractProduct> getAbstractProductList() {
        return abstractProductList;
    }

    public void setAbstractProductList(List<AbstractProduct> abstractProductList) {
        this.abstractProductList = abstractProductList;
    }
}
