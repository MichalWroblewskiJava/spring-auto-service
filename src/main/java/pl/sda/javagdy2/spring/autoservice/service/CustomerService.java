package pl.sda.javagdy2.spring.autoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.javagdy2.spring.autoservice.model.Customer;
import pl.sda.javagdy2.spring.autoservice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getDataBase() {
        return customerRepository.findAll();
    }

}