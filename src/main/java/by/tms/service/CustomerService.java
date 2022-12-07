package by.tms.service;

import by.tms.entity.Customer;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CustomerService {

//    private final Storage<Customer, Long> customerStorage;
//
//    public CustomerService(@Qualifier("inMemoryCustomerStorage") Storage<Customer, Long> customerStorage) {
//        this.customerStorage = customerStorage;
//    }
//
//    public Customer saveCustomer(Customer customer){
//        customerStorage.save(customer);
//        return customer;
//    }
//
//    public Optional<Customer> findCustomerByEmail(String email){
//        return customerStorage.findEntity(email);
//    }

}
