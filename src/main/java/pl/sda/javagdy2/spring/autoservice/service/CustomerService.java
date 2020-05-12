package pl.sda.javagdy2.spring.autoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.javagdy2.spring.autoservice.model.Customer;
import pl.sda.javagdy2.spring.autoservice.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> findCustomer(Long id) {
        return customerRepository.findById(id);
    }


    public List<Customer> getDataBase() {
        return customerRepository.findAll();
    }

    public void deleteById(Long customerIndentifier) {
        customerRepository.deleteById(customerIndentifier);
    }
}