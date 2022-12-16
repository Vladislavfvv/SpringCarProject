package by.tms.service;

import by.tms.entity.AbstractVehicle;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    private final Storage<AbstractVehicle, Long> vehicleService;

    public CarService(@Qualifier("hibernateCarDao") Storage<AbstractVehicle, Long> vehicleService) {
        this.vehicleService = vehicleService;
    }

    public AbstractVehicle save(AbstractVehicle vehicle) {
        vehicleService.save(vehicle);
        return vehicle;
    }

    public Optional<AbstractVehicle> findVehicleById(Long id) {
        return vehicleService.findById(id);
    }

    public Optional<AbstractVehicle> findVehicleByName(String nameVehicle) {
        return vehicleService.findEntity(nameVehicle);
    }
}
