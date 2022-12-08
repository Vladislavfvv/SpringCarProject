package by.tms.service;

import by.tms.entity.AbstractProduct;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

//    private final Storage<AbstractProduct, Long> vehicleService;
//
//    public VehicleService(@Qualifier("inMemoryProductStorage") Storage<AbstractProduct, Long> vehicleService) {
//        this.vehicleService = vehicleService;
//    }
//
//    public AbstractProduct save(AbstractProduct vehicle){
//        vehicleService.save(vehicle);
//        return vehicle;
//    }
//
//    public Optional<AbstractProduct> findVehicleById(Long id){
//        return vehicleService.findById(id);
//    }
}
