package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tire extends AbstractProduct{
    @NotBlank(message = "Field must not be empty")
    @Size(message = "The tire size must contain 14 symbols, like as P225/70R16 98H", min = 14, max = 18)
    private String tireSize;

    public String getTireSize() {
        return tireSize;
    }

    public void setTireSize(String tireSize) {
        this.tireSize = tireSize;
    }
}
