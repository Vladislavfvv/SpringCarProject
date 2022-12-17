package by.tms.service;

import by.tms.entity.AbstractVehicle;
import by.tms.entity.Car;
import by.tms.entity.User;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final Storage<AbstractVehicle, Long> carService;

    public CarService(@Qualifier("hibernateCarDao") Storage<AbstractVehicle, Long> carService) {
        this.carService = carService;
    }

    public AbstractVehicle save(AbstractVehicle vehicle) {
        carService.save(vehicle);
        return vehicle;
    }

    public Optional<AbstractVehicle> findVehicleById(Long id) {
        return carService.findById(id);
    }

    public Optional<AbstractVehicle> findVehicleByName(String nameVehicle) {
        return carService.findEntity(nameVehicle);
    }

    public List<AbstractVehicle> getAbstractVehicle() {
        return carService.getListOfEntity();
    }

    public AbstractVehicle saveCar(MultipartFile file, String srcPicture, String nameProduct, String releaseDate, String color, String producer, String passengerCapacity, User user) {

        AbstractVehicle car = new Car();
        car.setUser(user);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("Not valid file");
        }
//        try {
//            //car.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        car.setSrcPicture(srcPicture);
        car.setNameProduct(nameProduct);
        car.setProducer(producer);
        car.setReleaseDate(releaseDate);
        car.setColor(color);

        carService.save(car);
        return car;
    }

    public Optional<AbstractVehicle> findVehicleByOwner(User currentUser) {
        return carService.findVehicleByOwner(currentUser);
    }
}
