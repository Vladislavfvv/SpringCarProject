package by.tms.storage;

import by.tms.entity.User;

import java.util.List;
import java.util.Optional;

public interface Storage<T, ID> extends CrudDao<T, ID> {
    List<T> getListOfEntity();

    Optional<T> findEntity(String parameter);

    Optional<T> findVehicleByOwner(User currentUser);
}
