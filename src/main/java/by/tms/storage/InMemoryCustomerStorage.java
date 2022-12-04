package by.tms.storage;

import by.tms.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryCustomerStorage")
public class InMemoryCustomerStorage implements Storage<Customer, Long> {

    private final AtomicLong customerIdGenerator = new AtomicLong(0);
    private final List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer save(Customer entity) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Customer delete(Customer entity) {
        return null;
    }

    @Override
    public List<Customer> getListOfEntity() {
        return null;
    }

    @Override
    public Optional<Customer> findEntity(String parameter) {
        return Optional.empty();
    }
}
