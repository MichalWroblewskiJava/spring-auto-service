package pl.sda.javagdy2.spring.autoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javagdy2.spring.autoservice.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllBySurname(String findSurname);
}
