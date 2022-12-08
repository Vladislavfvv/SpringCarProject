package by.tms.storage;

import by.tms.entity.AbstractProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryVehicleStorage")
public class InMemoryProductStorage implements Storage<AbstractProduct, Long> {

    private final AtomicLong idVehicleGenerator = new AtomicLong(0);
    private final List<AbstractProduct> vehicleList = new ArrayList<>();


    @Override
    public AbstractProduct save(AbstractProduct vehicle) {
        vehicle.setId(idVehicleGenerator.incrementAndGet());
        vehicleList.add(vehicle);
        return vehicle;
    }

    @Override
    public Optional<AbstractProduct> findById(Long aLong) {
        for (AbstractProduct vehicle: vehicleList) {
            if (vehicle.getId() == aLong)
                return Optional.of(vehicle);
        }
        return Optional.empty();
    }

    @Override
    public AbstractProduct delete(AbstractProduct entity) {
        vehicleList.remove(entity);
        return entity;
    }

    @Override
    public List<AbstractProduct> getListOfEntity() {
        return vehicleList;
    }

    @Override
    public Optional<AbstractProduct> findEntity(String nameVehicle) {
        for (AbstractProduct vehicle: vehicleList) {
            if(vehicle.getNameProduct().equals(nameVehicle))
                return Optional.of(vehicle);
        }
        return Optional.empty();
    }
}
