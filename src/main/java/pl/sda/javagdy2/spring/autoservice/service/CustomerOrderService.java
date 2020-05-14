package pl.sda.javagdy2.spring.autoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.javagdy2.spring.autoservice.model.Customer;
import pl.sda.javagdy2.spring.autoservice.model.CustomerOrder;
import pl.sda.javagdy2.spring.autoservice.model.Fault;
import pl.sda.javagdy2.spring.autoservice.repository.CustomerOrderRepository;
import pl.sda.javagdy2.spring.autoservice.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    public void saveOrder(CustomerOrder customerOrder, Long customerId){
        Optional<Customer> customerOptional= customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            customerOrder.setCustomer(customer);
            customerOrderRepository.save(customerOrder);
        }
    }
    public Optional<CustomerOrder> findById(Long orderId){
        return customerOrderRepository.findById(orderId);
    }
    public void deleteById(Long customerOrderId) {
        customerOrderRepository.deleteById(customerOrderId);
    }

}
