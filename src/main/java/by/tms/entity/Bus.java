package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "buses")
public class Bus extends AbstractVehicle {


    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must contain 1 to 30", min = 1, max = 30)
    private int passengerCapacity;



    public Bus() {
    }


}
