package by.tms.storage;

import by.tms.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component("inMemoryCustomerStorage")
public class InMemoryCustomerStorage
//        implements Storage<Customer, Long>
{

//    private final AtomicLong customerIdGenerator = new AtomicLong(0);
//    private final List<Customer> customerList = new ArrayList<>();
//
//    @Override
//    public Customer save(Customer customer) {
//        customer.setId(customerIdGenerator.incrementAndGet());
//        customerList.add(customer);
//        return customer;
//    }
//
//    @Override
//    public Optional<Customer> findById(Long aLong) {
//        for (Customer customer : customerList) {
//            if (customer.getId() == aLong)
//                return Optional.of(customer);
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public Customer delete(Customer entity) {
//        customerList.remove(entity);
//        return entity;
//    }
//
//    @Override
//    public List<Customer> getListOfEntity() {
//        return customerList;
//    }
//
//    @Override
//    public Optional<Customer> findEntity(String email) {
//        for (Customer customer: customerList) {
//            if(customer.getEmail().equals(email))
//                return Optional.of(customer);
//        }
//        return Optional.empty();
//    }
}
