package by.tms.storage;

import by.tms.entity.AbstractVehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryVehicleStorage")
public class InMemoryVehicleStorage implements Storage<AbstractVehicle, Long> {

    private final AtomicLong idVehicleGenerator = new AtomicLong(0);
    private final List<AbstractVehicle> vehicleList = new ArrayList<>();


    @Override
    public AbstractVehicle save(AbstractVehicle vehicle) {
        vehicle.setId(idVehicleGenerator.incrementAndGet());
        vehicleList.add(vehicle);
        return vehicle;
    }

    @Override
    public Optional<AbstractVehicle> findById(Long aLong) {
        for (AbstractVehicle vehicle: vehicleList) {
            if (vehicle.getId() == aLong)
                return Optional.of(vehicle);
        }
        return Optional.empty();
    }

    @Override
    public AbstractVehicle delete(AbstractVehicle entity) {
        vehicleList.remove(entity);
        return entity;
    }

    @Override
    public List<AbstractVehicle> getListOfEntity() {
        return vehicleList;
    }

    @Override
    public Optional<AbstractVehicle> findEntity(String nameVehicle) {
        for (AbstractVehicle vehicle: vehicleList) {
            if(vehicle.getNameVehicle().equals(nameVehicle))
                return Optional.of(vehicle);
        }
        return Optional.empty();
    }
}
